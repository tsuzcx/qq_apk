package com.tencent.mm.plugin.emojicapture.e;

import a.d.a.b;
import a.n;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.api.j;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.f.a.a;
import com.tencent.mm.plugin.emojicapture.model.b.f;
import com.tencent.mm.plugin.emojicapture.model.b.f.c;
import com.tencent.mm.plugin.emojicapture.model.b.f.d;
import com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.ttpic.baseutils.SourcePathUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  implements b.a
{
  final String TAG;
  Context context;
  private final com.tencent.mm.remoteservice.d eMh;
  final String iZb;
  private final boolean jkl;
  String jlX;
  boolean jmA;
  f jmB;
  private boolean jmC;
  boolean jmD;
  private final CgiEmojiTextSpamProxy jmE;
  b.b jmF;
  EmojiCaptureUI.b jmd;
  boolean jmz;
  
  public c(Context paramContext, b.b paramb, boolean paramBoolean, EmojiCaptureUI.b paramb1, String paramString)
  {
    this.context = paramContext;
    this.jmF = paramb;
    this.jkl = paramBoolean;
    this.jmd = paramb1;
    this.iZb = paramString;
    this.TAG = "MicroMsg.EditorPresenter";
    this.eMh = new com.tencent.mm.remoteservice.d(this.context);
    this.jmE = new CgiEmojiTextSpamProxy(this.eMh);
  }
  
  private final void a(String paramString, b<? super Boolean, n> paramb)
  {
    if (bk.bl(paramString))
    {
      paramb.W(Boolean.valueOf(false));
      return;
    }
    this.jmE.cgiEmojiTextSpam(paramString, (b)new c.a(paramb));
  }
  
  private final void ft(boolean paramBoolean)
  {
    if ((paramBoolean) && (SourcePathUtil.isLoadBgCutSo())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jmD = paramBoolean;
      return;
    }
  }
  
  public final void Bi(String paramString)
  {
    y.i(this.TAG, "voice text callback");
    a(paramString, (b)new c.d(this, paramString));
  }
  
  public final boolean aJQ()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    y.i(this.TAG, "removeBg " + this.jmD);
    if (this.jmF.getVideoPlayView().isPlaying())
    {
      bool1 = bool2;
      if (!this.jmD) {
        bool1 = true;
      }
      ft(bool1);
      EmojiVideoPlayTextureView.a(this.jmF.getVideoPlayView(), this.jmD);
      bool1 = this.jmD;
    }
    return bool1;
  }
  
  public final boolean aJR()
  {
    y.i(this.TAG, "speedUp " + this.jmC);
    if (this.jmF.getVideoPlayView().getPlayRate() == 1.0F)
    {
      this.jmF.getVideoPlayView().setPlayRate(2.0F);
      this.jmC = true;
      return true;
    }
    this.jmF.getVideoPlayView().setPlayRate(1.0F);
    this.jmC = false;
    return false;
  }
  
  public final void aJS()
  {
    if (!bk.bl(this.iZb))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
      a.d.b.g.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
      if (!((Boolean)((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().a(ac.a.uzB, Boolean.valueOf(false))).booleanValue())
      {
        new com.tencent.mm.ui.widget.a.c.a(this.context).Iq(a.f.dialog_first_open_imitate_msg).Is(a.f.dialog_first_open_confirm).a((DialogInterface.OnDismissListener)new c.b(this)).show();
        locala = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class);
        a.d.b.g.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().b(ac.a.uzB, Boolean.valueOf(true));
        return;
      }
    }
    aKn();
  }
  
  final void aKn()
  {
    Object localObject2 = null;
    y.i(this.TAG, "start mix " + this.jmF.getVideoPlayView().getVideoPath());
    Object localObject1 = new com.tencent.mm.plugin.emojicapture.model.b.a(this.jmF.getItemContainer().getValidRect());
    Object localObject3 = this.jmF.getItemContainer().getAllItemViews();
    ArrayList localArrayList = this.jmF.getItemContainer().getAllEmojiMd5();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((com.tencent.mm.plugin.emojicapture.ui.editor.a)((Iterator)localObject3).next()).aKU();
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject1).jkF.add(localObject4);
      }
    }
    localObject3 = this.jmF.getVideoPlayView().getVideoPath();
    Object localObject4 = (com.tencent.mm.plugin.emojicapture.model.b.c)localObject1;
    Object localObject5 = com.tencent.mm.plugin.emojicapture.model.c.jko;
    localObject5 = com.tencent.mm.plugin.emojicapture.model.c.a.aKe() + "temp_gif";
    int i = (int)this.jmF.getVideoPlayView().getPlayRate();
    boolean bool2 = this.jmD;
    boolean bool1;
    label335:
    double d;
    label354:
    Object localObject6;
    if (!this.jkl)
    {
      bool1 = true;
      this.jmB = new f((String)localObject3, (com.tencent.mm.plugin.emojicapture.model.b.c)localObject4, (String)localObject5, i, bool2, bool1);
      pause();
      ((com.tencent.mm.plugin.emojicapture.model.b.a)localObject1).start();
      localObject4 = p.b(this.context, (CharSequence)this.context.getString(a.f.emoji_generating), true, 0, null);
      localObject3 = this.jmB;
      if (localObject3 != null)
      {
        localObject5 = (a.d.a.a)new c.c(this, (com.tencent.mm.plugin.emojicapture.model.b.a)localObject1, localArrayList, (p)localObject4);
        localObject4 = com.tencent.mm.plugin.sight.base.d.MH(((f)localObject3).videoPath);
        if (localObject4 == null) {
          break label881;
        }
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject4).eIM);
        if (!(localObject1 instanceof Integer)) {
          break label887;
        }
        d = 1000.0D / ((com.tencent.mm.plugin.sight.base.a)localObject4).eIM;
        ((f)localObject3).jlh = ((a.d.a.a)localObject5);
        localObject5 = ((f)localObject3).TAG;
        localObject1 = new StringBuilder("start decode ");
        localObject6 = Thread.currentThread();
        a.d.b.g.j(localObject6, "Thread.currentThread()");
        localObject6 = ((StringBuilder)localObject1).append(((Thread)localObject6).getId()).append(", fps: ");
        if (localObject4 == null) {
          break label892;
        }
      }
    }
    label881:
    label887:
    label892:
    for (localObject1 = Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject4).eIM);; localObject1 = null)
    {
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", duration: ");
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject4).jlu);
      }
      y.i((String)localObject5, localObject1 + ", videoFrameDuration: " + d + ", removeBackground:" + ((f)localObject3).jll + ", path: " + ((f)localObject3).videoPath);
      long l = bk.UZ();
      ((f)localObject3).frameCount = 0;
      ((f)localObject3).jlf = new com.tencent.mm.plugin.emojicapture.model.b.g(((f)localObject3).videoPath, ((f)localObject3).jli, ((f)localObject3).jlk);
      if (!bk.bl(((f)localObject3).jlj))
      {
        localObject1 = ((f)localObject3).jlj;
        localObject2 = com.tencent.mm.plugin.emojicapture.model.c.jko;
        i = com.tencent.mm.plugin.emojicapture.model.c.aKd();
        localObject2 = com.tencent.mm.plugin.emojicapture.model.c.jko;
        int j = com.tencent.mm.plugin.emojicapture.model.c.aKd();
        localObject2 = ((f)localObject3).jlf;
        if (localObject2 == null) {
          a.d.b.g.ahh("syncMgr");
        }
        ((f)localObject3).jlg = new com.tencent.mm.plugin.emojicapture.model.b.d((String)localObject1, i, j, ((com.tencent.mm.plugin.emojicapture.model.b.g)localObject2).jlC, ((f)localObject3).jlm);
      }
      ((f)localObject3).jkM = bk.UZ();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.c.jko;
      i = com.tencent.mm.plugin.emojicapture.model.c.aKd();
      localObject1 = com.tencent.mm.plugin.emojicapture.model.c.jko;
      ((f)localObject3).jle = new com.tencent.mm.plugin.emojicapture.ui.a.c(i, com.tencent.mm.plugin.emojicapture.model.c.aKd());
      localObject1 = ((f)localObject3).jle;
      if (localObject1 == null) {
        a.d.b.g.ahh("mixPixelBuffer");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.a.c)localObject1).jrf = ((a.d.a.a)new f.c((f)localObject3));
      localObject1 = ((f)localObject3).jle;
      if (localObject1 == null) {
        a.d.b.g.ahh("mixPixelBuffer");
      }
      localObject2 = (a.d.a.a)new f.d((f)localObject3, l);
      ((com.tencent.mm.plugin.emojicapture.ui.a.c)localObject1).jrd.post((Runnable)new com.tencent.mm.plugin.emojicapture.ui.a.c.b((com.tencent.mm.plugin.emojicapture.ui.a.c)localObject1, (a.d.a.a)localObject2));
      localObject1 = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      localObject2 = this.jmF.getItemContainer().getAttachedText();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.emojicapture.f.a.Bj((String)localObject1);
      localObject1 = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      localObject1 = this.jmF.getItemContainer().getTextItem();
      if (localObject1 == null) {
        a.d.b.g.cUk();
      }
      com.tencent.mm.plugin.emojicapture.f.a.qj(((TextEditorItemView)localObject1).getTextColor());
      localObject1 = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.fu(this.jmD);
      localObject1 = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.fv(this.jmC);
      localObject1 = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.qk(localArrayList.size());
      return;
      bool1 = false;
      break;
      localObject1 = null;
      break label335;
      d = 0.0D;
      break label354;
    }
  }
  
  public final void ao(String paramString, boolean paramBoolean)
  {
    a.d.b.g.k(paramString, "videoPath");
    y.i(this.TAG, "setup");
    ft(paramBoolean);
    this.jmF.a(paramString, this.jmD, (a.d.a.a)new c.f(this));
  }
  
  public final void b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    y.i(this.TAG, "updateText " + paramString);
    a(paramString, (b)new c.g(this, p.b(this.context, (CharSequence)this.context.getString(a.f.loading_tips), true, 0, null), paramString, paramInt1, paramInt2, paramBoolean));
  }
  
  public final void c(j paramj)
  {
    a.d.b.g.k(paramj, "emojiInfo");
    if ((paramj instanceof EmojiInfo))
    {
      if (this.jmF.getItemContainer().getAllEmojiMd5().size() >= 8) {
        s.makeText(this.context, a.f.emoji_attached_emoji_max_size, 0).show();
      }
    }
    else {
      return;
    }
    com.tencent.mm.plugin.emojicapture.ui.editor.a locala = (com.tencent.mm.plugin.emojicapture.ui.editor.a)new EmojiEditorItemView(this.context);
    ((EmojiEditorItemView)locala).setEmojiInfo((EmojiInfo)paramj);
    locala.resume();
    paramj = this.jmF.getItemContainer();
    a.d.b.g.k(locala, "itemView");
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    paramj.addView((View)locala, (ViewGroup.LayoutParams)localObject);
    localObject = paramj.getValidRect();
    Context localContext = paramj.getContext();
    a.d.b.g.j(localContext, "context");
    locala.a((RectF)localObject, localContext.getResources().getDimension(a.b.preview_radius));
    paramj.removeCallbacks(paramj.jpX);
    paramj.a(locala, true);
    paramj.postDelayed(paramj.jpX, 1500L);
    paramj.bringChildToFront((View)paramj.getTextItem());
  }
  
  public final void destroy()
  {
    y.i(this.TAG, "destroy");
    this.jmF.getVideoPlayView().stop();
    this.jmF.destroy();
    this.eMh.release();
  }
  
  public final void pause()
  {
    y.i(this.TAG, "pause");
    Object localObject2;
    if (this.jmF.getVideoPlayView().isPlaying())
    {
      localObject1 = this.jmF.getVideoPlayView();
      if (((EmojiVideoPlayTextureView)localObject1).joI != null)
      {
        localObject2 = ((EmojiVideoPlayTextureView)localObject1).joI;
        if (localObject2 == null) {
          a.d.b.g.cUk();
        }
        if (((i)localObject2).isPlaying())
        {
          localObject2 = ((EmojiVideoPlayTextureView)localObject1).joI;
          if (localObject2 != null) {
            ((i)localObject2).pause();
          }
          localObject2 = ((EmojiVideoPlayTextureView)localObject1).joH;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.emojicapture.ui.d)localObject2).joy = true;
          }
        }
      }
      ((EmojiVideoPlayTextureView)localObject1).joT = false;
    }
    Object localObject1 = this.jmF.getItemContainer();
    int j = ((EditorItemContainer)localObject1).getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject2 = ((EditorItemContainer)localObject1).getChildAt(i);
      if ((localObject2 instanceof com.tencent.mm.plugin.emojicapture.ui.editor.a)) {
        ((com.tencent.mm.plugin.emojicapture.ui.editor.a)localObject2).pause();
      }
      i += 1;
    }
  }
  
  public final boolean rG()
  {
    int i = 0;
    boolean bool = false;
    if (this.jmF.akH())
    {
      if (this.jmF.aJU())
      {
        this.jmF.a(false, null, 0);
        bool = true;
      }
    }
    else {
      return bool;
    }
    if (this.jmF.aJV())
    {
      this.jmF.fs(false);
      return true;
    }
    ft(false);
    this.jmC = false;
    this.jlX = null;
    this.jmz = false;
    this.jmA = false;
    this.jmF.getVideoPlayView().stop();
    Object localObject = this.jmF.getItemContainer();
    while (i < ((EditorItemContainer)localObject).getChildCount())
    {
      View localView = ((EditorItemContainer)localObject).getChildAt(i);
      if ((localView instanceof com.tencent.mm.plugin.emojicapture.ui.editor.a)) {
        ((EditorItemContainer)localObject).removeView(localView);
      } else {
        i += 1;
      }
    }
    this.jmd.aKK();
    localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
    a.a.a(9, 0L, 0L, 0L);
    return true;
  }
  
  public final void resume()
  {
    y.i(this.TAG, "resume");
    this.jmF.getVideoPlayView().start();
    EditorItemContainer localEditorItemContainer = this.jmF.getItemContainer();
    int j = localEditorItemContainer.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localEditorItemContainer.getChildAt(i);
      if ((localView instanceof com.tencent.mm.plugin.emojicapture.ui.editor.a)) {
        ((com.tencent.mm.plugin.emojicapture.ui.editor.a)localView).resume();
      }
      i += 1;
    }
  }
  
  static final class e
    implements Runnable
  {
    e(c paramc) {}
    
    public final void run()
    {
      if ((this.jmJ.jmz) && (this.jmJ.jmA))
      {
        EmojiVideoPlayTextureView.a(this.jmJ.jmF.getVideoPlayView(), this.jmJ.jmD);
        this.jmJ.jmF.aJT();
        this.jmJ.jmd.aKL();
        c.a(this.jmJ, this.jmJ.jlX, -1, -16777216, true);
        this.jmJ.jmA = false;
        this.jmJ.jmz = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c
 * JD-Core Version:    0.7.0.1
 */
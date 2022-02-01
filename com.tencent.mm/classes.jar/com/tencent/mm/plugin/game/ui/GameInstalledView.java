package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> xTn;
  private static int xTp;
  private static int xTq;
  private int count;
  private Context mContext;
  private int xGR;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> xHv;
  private k.a xQH;
  private LinearLayout xTj;
  private ImageView xTk;
  private TextView xTl;
  private TextView xTm;
  private final DisplayMetrics xTo;
  private int xTr;
  private int xTs;
  private int xTt;
  private a xTu;
  private LinkedList<com.tencent.mm.plugin.game.model.c> xTv;
  LinearLayout.LayoutParams xTw;
  
  static
  {
    AppMethodBeat.i(42192);
    xTn = new HashMap();
    xTp = 6;
    xTq = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.xHv = new LinkedList();
    this.xTo = new DisplayMetrics();
    this.xTr = 4;
    this.count = 0;
    this.xGR = 0;
    this.xTs = 1;
    this.xTt = 999;
    this.xTw = new LinearLayout.LayoutParams(-1, -2);
    this.xQH = new k.a()
    {
      public final void e(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(42185);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(42185);
          return;
          AppMethodBeat.o(42185);
          return;
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void dWr()
  {
    AppMethodBeat.i(42189);
    if (Util.isNullOrNil(this.xHv))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.xTj.removeAllViews();
    this.count = 0;
    Object localObject1 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    int j;
    int i;
    int k;
    Object localObject2;
    label274:
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.xHv.size() >= this.xTr - 1)
    {
      xTq = 7;
      xTp = 6;
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (xTp << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.xTo);
      i = (int)(this.xTo.widthPixels * 160 / this.xTo.densityDpi);
      this.xTr = ((this.xTo.widthPixels - 1) / j + 1);
      if (this.xTr == 3) {
        xTq = 3;
      }
      j = (xTp << 1) + 84;
      k = xTp + 6 + xTq;
      i = (i - 16) % j;
      if (i < k)
      {
        xTp -= 2;
        BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (xTp << 1) + 84);
      }
    }
    else
    {
      this.xTw.setMargins(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, xTp), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, xTp), 0);
      localObject2 = this.xHv.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2131495077, null);
      this.xTk = ((ImageView)((View)localObject4).findViewById(2131301985));
      this.xTl = ((TextView)((View)localObject4).findViewById(2131302051));
      this.xTm = ((TextView)((View)localObject4).findViewById(2131302080));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.xTk.setImageBitmap((Bitmap)localObject5);
      label380:
      this.xTl.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.e.c.aAH(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!xTn.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)xTn.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = com.tencent.mm.plugin.downloader.model.f.cBv().alg(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.xTm.setTextColor(this.mContext.getResources().getColor(2131100538));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.xTm.setText(2131761162);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.xTj.addView((View)localObject4, this.xTw);
      break label274;
      if (i <= j - k) {
        break;
      }
      xTp = (i - (j >> 1)) / this.xTr + xTp;
      BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (xTp << 1) + 84);
      break;
      label582:
      this.xTk.setImageResource(2131231085);
      break label380;
      label595:
      this.xTm.setText(2131761161);
      continue;
      label608:
      if (!Util.isNullOrNil(((y)localObject3).fmI))
      {
        this.xTm.setText(((y)localObject3).fmI);
        this.xTm.setTextColor(this.mContext.getResources().getColor(2131100555));
      }
      else
      {
        this.xTm.setText("");
        continue;
        this.xTm.setTextColor(this.mContext.getResources().getColor(2131100538));
        this.xTm.setText(2131761254);
      }
    }
    label700:
    if ((this.xTu != null) && (this.xTu.iconUrl != null) && (this.xTu.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131495077, null);
      this.xTk = ((ImageView)((View)localObject1).findViewById(2131301985));
      this.xTl = ((TextView)((View)localObject1).findViewById(2131302051));
      this.xTm = ((TextView)((View)localObject1).findViewById(2131302080));
      localObject2 = q.bcV();
      localObject3 = this.xTu.iconUrl;
      localObject4 = this.xTk;
      localObject5 = new c.a();
      ((c.a)localObject5).jbe = true;
      ((com.tencent.mm.av.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).bdv(), new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42184);
          if (paramAnonymousb.status == 0) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42183);
                if (GameInstalledView.a(GameInstalledView.this) == 0)
                {
                  GameInstalledView.b(GameInstalledView.this);
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.xTw);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.xTl.setText(this.xTu.title);
      this.xTm.setVisibility(8);
      ((View)localObject1).setTag(this.xTu);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView.getTag() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (Util.isNullOrNil(paramView.field_appId)))
      {
        Log.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.e.c.aAH(paramView.field_packageName);
        if ((xTn.containsKey(paramView.field_appId)) && (((Integer)xTn.get(paramView.field_appId)).intValue() > i))
        {
          localObject = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((FileDownloadTaskInfo)localObject).id);
          }
        }
        for (;;)
        {
          refresh(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          if (((FileDownloadTaskInfo)localObject).status == 3)
          {
            if ((s.YS(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.e.c.aAJ(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.r(paramView.fmE, paramView.fmJ, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).alj(paramView.fmE);
            ((g.a)localObject).all(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).setFileMD5(paramView.fmJ);
            ((g.a)localObject).kS(true);
            ((g.a)localObject).Fl(1);
            com.tencent.mm.plugin.downloader.model.f.cBv().a(((g.a)localObject).qIY);
            continue;
            com.tencent.mm.plugin.game.model.e.at(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.xTs, 3, 0, paramView.field_appId, this.xGR, 0, null, null, null);
            this.xHv.remove(paramView);
            this.xHv.addFirst(paramView);
          }
        }
      }
      localObject = com.tencent.mm.plugin.downloader.model.f.cBv().alg(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!Util.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (s.YS(((FileDownloadTaskInfo)localObject).path))) {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          Log.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((FileDownloadTaskInfo)localObject).id);
          refresh(false);
        }
      }
      Log.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
      refresh(false);
    }
    while (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    localObject = (a)paramView.getTag();
    paramView = new Intent();
    if (Util.isNullOrNil(((a)localObject).lDS))
    {
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (int i = 6;; i = com.tencent.mm.plugin.game.e.c.D(this.mContext, ((a)localObject).lDS, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.xTt, i, 0, null, this.xGR, 0, null, null, null);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.xTj = ((LinearLayout)findViewById(2131301996));
    k.a(this.xQH);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (Util.isNullOrNil(this.xTv))
    {
      setVisibility(8);
      AppMethodBeat.o(42188);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      this.xHv = com.tencent.mm.plugin.game.model.e.dUQ();
      if ((!Util.isNullOrNil(this.xTv)) && (!Util.isNullOrNil(this.xHv)))
      {
        localObject1 = this.xTv.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.xHv.contains(localObject2))
          {
            this.xHv.remove(localObject2);
            this.xHv.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.xHv);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.dUQ());
      localObject2 = new LinkedList();
      Object localObject4 = ((LinkedList)localObject1).iterator();
      com.tencent.mm.pluginsdk.model.app.g localg;
      while (((Iterator)localObject4).hasNext())
      {
        localg = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject4).next();
        if ((!((LinkedList)localObject3).contains(localg)) && (!((LinkedList)localObject2).contains(localg))) {
          ((LinkedList)localObject2).add(localg);
        }
      }
      localObject4 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localg = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject4).next();
        if (((LinkedList)localObject3).contains(localg)) {
          ((LinkedList)localObject3).remove(localg);
        } else if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, localg)) {
          ((LinkedList)localObject2).add(localg);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject3).next();
          if (!((LinkedList)localObject1).contains(localObject4)) {
            ((LinkedList)localObject1).addFirst(localObject4);
          }
        }
      }
      if (((LinkedList)localObject2).size() > 0) {
        ((LinkedList)localObject1).removeAll((Collection)localObject2);
      }
      localObject2 = new LinkedList();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((LinkedList)localObject2).add(com.tencent.mm.pluginsdk.model.app.h.o(((com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next()).field_appId, true, false));
      }
      this.xHv = ((LinkedList)localObject2);
    }
    dWr();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.xTv = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.xTu = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.xGR = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    xTn = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static final class a
  {
    public String iconUrl = "";
    public String lDS = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
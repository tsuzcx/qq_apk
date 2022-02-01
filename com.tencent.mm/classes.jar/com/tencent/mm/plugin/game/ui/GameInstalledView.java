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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> uBp;
  private static int uBr;
  private static int uBs;
  private int count;
  private Context mContext;
  private LinearLayout uBl;
  private ImageView uBm;
  private TextView uBn;
  private TextView uBo;
  private final DisplayMetrics uBq;
  private int uBt;
  private int uBu;
  private int uBv;
  private a uBw;
  private LinkedList<com.tencent.mm.plugin.game.model.c> uBx;
  LinearLayout.LayoutParams uBy;
  private int uoy;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> upc;
  private k.a uyI;
  
  static
  {
    AppMethodBeat.i(42192);
    uBp = new HashMap();
    uBr = 6;
    uBs = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.upc = new LinkedList();
    this.uBq = new DisplayMetrics();
    this.uBt = 4;
    this.count = 0;
    this.uoy = 0;
    this.uBu = 1;
    this.uBv = 999;
    this.uBy = new LinearLayout.LayoutParams(-1, -2);
    this.uyI = new k.a()
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
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZj().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void dcK()
  {
    AppMethodBeat.i(42189);
    if (bu.ht(this.upc))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.uBl.removeAllViews();
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
    if (this.upc.size() >= this.uBt - 1)
    {
      uBs = 7;
      uBr = 6;
      j = BackwardSupportUtil.b.h(this.mContext, (uBr << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.uBq);
      i = (int)(this.uBq.widthPixels * 160 / this.uBq.densityDpi);
      this.uBt = ((this.uBq.widthPixels - 1) / j + 1);
      if (this.uBt == 3) {
        uBs = 3;
      }
      j = (uBr << 1) + 84;
      k = uBr + 6 + uBs;
      i = (i - 16) % j;
      if (i < k)
      {
        uBr -= 2;
        BackwardSupportUtil.b.h(this.mContext, (uBr << 1) + 84);
      }
    }
    else
    {
      this.uBy.setMargins(BackwardSupportUtil.b.h(this.mContext, uBr), 0, BackwardSupportUtil.b.h(this.mContext, uBr), 0);
      localObject2 = this.upc.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.uBm = ((ImageView)((View)localObject4).findViewById(2131300462));
      this.uBn = ((TextView)((View)localObject4).findViewById(2131300524));
      this.uBo = ((TextView)((View)localObject4).findViewById(2131300548));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.uBm.setImageBitmap((Bitmap)localObject5);
      label380:
      this.uBn.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.f.c.anq(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!uBp.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)uBp.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.uBo.setTextColor(this.mContext.getResources().getColor(2131100436));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.uBo.setText(2131759832);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.uBl.addView((View)localObject4, this.uBy);
      break label274;
      if (i <= j - k) {
        break;
      }
      uBr = (i - (j >> 1)) / this.uBt + uBr;
      BackwardSupportUtil.b.h(this.mContext, (uBr << 1) + 84);
      break;
      label582:
      this.uBm.setImageResource(2131231052);
      break label380;
      label595:
      this.uBo.setText(2131759831);
      continue;
      label608:
      if (!bu.isNullOrNil(((y)localObject3).eJg))
      {
        this.uBo.setText(((y)localObject3).eJg);
        this.uBo.setTextColor(this.mContext.getResources().getColor(2131100453));
      }
      else
      {
        this.uBo.setText("");
        continue;
        this.uBo.setTextColor(this.mContext.getResources().getColor(2131100436));
        this.uBo.setText(2131759906);
      }
    }
    label700:
    if ((this.uBw != null) && (this.uBw.iconUrl != null) && (this.uBw.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.uBm = ((ImageView)((View)localObject1).findViewById(2131300462));
      this.uBn = ((TextView)((View)localObject1).findViewById(2131300524));
      this.uBo = ((TextView)((View)localObject1).findViewById(2131300548));
      localObject2 = q.aJb();
      localObject3 = this.uBw.iconUrl;
      localObject4 = this.uBm;
      localObject5 = new c.a();
      ((c.a)localObject5).igj = true;
      ((com.tencent.mm.av.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).aJu(), new com.tencent.mm.av.a.c.h()
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
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42183);
                if (GameInstalledView.a(GameInstalledView.this) == 0)
                {
                  GameInstalledView.b(GameInstalledView.this);
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.uBy);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.uBn.setText(this.uBw.title);
      this.uBo.setVisibility(8);
      ((View)localObject1).setTag(this.uBw);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView.getTag() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (bu.isNullOrNil(paramView.field_appId)))
      {
        ae.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.f.c.anq(paramView.field_packageName);
        if ((uBp.containsKey(paramView.field_appId)) && (((Integer)uBp.get(paramView.field_appId)).intValue() > i))
        {
          localObject = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            com.tencent.mm.plugin.downloader.model.f.cdA().ui(((FileDownloadTaskInfo)localObject).id);
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
            if ((o.fB(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.f.c.anr(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              com.tencent.mm.plugin.downloader.model.f.cdA().ui(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.n(paramView.eJc, paramView.eJh, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).abb(paramView.eJc);
            ((g.a)localObject).abd(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).abe(paramView.eJh);
            ((g.a)localObject).jP(true);
            ((g.a)localObject).BB(1);
            com.tencent.mm.plugin.downloader.model.f.cdA().a(((g.a)localObject).ptu);
            continue;
            com.tencent.mm.plugin.game.model.e.ak(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.uBu, 3, 0, paramView.field_appId, this.uoy, 0, null, null, null);
            this.upc.remove(paramView);
            this.upc.addFirst(paramView);
          }
        }
      }
      localObject = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!bu.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (o.fB(((FileDownloadTaskInfo)localObject).path))) {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          ae.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          com.tencent.mm.plugin.downloader.model.f.cdA().ui(((FileDownloadTaskInfo)localObject).id);
          refresh(false);
        }
      }
      ae.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
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
    if (bu.isNullOrNil(((a)localObject).kzz))
    {
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (int i = 6;; i = com.tencent.mm.plugin.game.f.c.B(this.mContext, ((a)localObject).kzz, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.uBv, i, 0, null, this.uoy, 0, null, null, null);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.uBl = ((LinearLayout)findViewById(2131300473));
    k.a(this.uyI);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (bu.ht(this.uBx))
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
      this.upc = com.tencent.mm.plugin.game.model.e.dbj();
      if ((!bu.ht(this.uBx)) && (!bu.ht(this.upc)))
      {
        localObject1 = this.uBx.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.upc.contains(localObject2))
          {
            this.upc.remove(localObject2);
            this.upc.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.upc);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.dbj());
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
        ((LinkedList)localObject2).add(com.tencent.mm.pluginsdk.model.app.h.m(((com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next()).field_appId, true, false));
      }
      this.upc = ((LinkedList)localObject2);
    }
    dcK();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.uBx = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.uBw = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.uoy = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    uBp = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static final class a
  {
    public String iconUrl = "";
    public String kzz = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
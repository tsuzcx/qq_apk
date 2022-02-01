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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> upT;
  private static int upV;
  private static int upW;
  private int count;
  private Context mContext;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> udU;
  private int udq;
  private k.a unm;
  private LinearLayout upP;
  private ImageView upQ;
  private TextView upR;
  private TextView upS;
  private final DisplayMetrics upU;
  private int upX;
  private int upY;
  private int upZ;
  private a uqa;
  private LinkedList<com.tencent.mm.plugin.game.model.c> uqb;
  LinearLayout.LayoutParams uqc;
  
  static
  {
    AppMethodBeat.i(42192);
    upT = new HashMap();
    upV = 6;
    upW = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.udU = new LinkedList();
    this.upU = new DisplayMetrics();
    this.upX = 4;
    this.count = 0;
    this.udq = 0;
    this.upY = 1;
    this.upZ = 999;
    this.uqc = new LinearLayout.LayoutParams(-1, -2);
    this.unm = new k.a()
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
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWF().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void cZZ()
  {
    AppMethodBeat.i(42189);
    if (bt.hj(this.udU))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.upP.removeAllViews();
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
    if (this.udU.size() >= this.upX - 1)
    {
      upW = 7;
      upV = 6;
      j = BackwardSupportUtil.b.g(this.mContext, (upV << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.upU);
      i = (int)(this.upU.widthPixels * 160 / this.upU.densityDpi);
      this.upX = ((this.upU.widthPixels - 1) / j + 1);
      if (this.upX == 3) {
        upW = 3;
      }
      j = (upV << 1) + 84;
      k = upV + 6 + upW;
      i = (i - 16) % j;
      if (i < k)
      {
        upV -= 2;
        BackwardSupportUtil.b.g(this.mContext, (upV << 1) + 84);
      }
    }
    else
    {
      this.uqc.setMargins(BackwardSupportUtil.b.g(this.mContext, upV), 0, BackwardSupportUtil.b.g(this.mContext, upV), 0);
      localObject2 = this.udU.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.upQ = ((ImageView)((View)localObject4).findViewById(2131300462));
      this.upR = ((TextView)((View)localObject4).findViewById(2131300524));
      this.upS = ((TextView)((View)localObject4).findViewById(2131300548));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cc.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.upQ.setImageBitmap((Bitmap)localObject5);
      label380:
      this.upR.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.f.c.ams(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!upT.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)upT.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = com.tencent.mm.plugin.downloader.model.f.ccl().aai(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.upS.setTextColor(this.mContext.getResources().getColor(2131100436));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.upS.setText(2131759832);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.upP.addView((View)localObject4, this.uqc);
      break label274;
      if (i <= j - k) {
        break;
      }
      upV = (i - (j >> 1)) / this.upX + upV;
      BackwardSupportUtil.b.g(this.mContext, (upV << 1) + 84);
      break;
      label582:
      this.upQ.setImageResource(2131231052);
      break label380;
      label595:
      this.upS.setText(2131759831);
      continue;
      label608:
      if (!bt.isNullOrNil(((y)localObject3).eHx))
      {
        this.upS.setText(((y)localObject3).eHx);
        this.upS.setTextColor(this.mContext.getResources().getColor(2131100453));
      }
      else
      {
        this.upS.setText("");
        continue;
        this.upS.setTextColor(this.mContext.getResources().getColor(2131100436));
        this.upS.setText(2131759906);
      }
    }
    label700:
    if ((this.uqa != null) && (this.uqa.iconUrl != null) && (this.uqa.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.upQ = ((ImageView)((View)localObject1).findViewById(2131300462));
      this.upR = ((TextView)((View)localObject1).findViewById(2131300524));
      this.upS = ((TextView)((View)localObject1).findViewById(2131300548));
      localObject2 = q.aIJ();
      localObject3 = this.uqa.iconUrl;
      localObject4 = this.upQ;
      localObject5 = new c.a();
      ((c.a)localObject5).idq = true;
      ((com.tencent.mm.aw.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).aJc(), new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42184);
          if (paramAnonymousb.status == 0) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42183);
                if (GameInstalledView.a(GameInstalledView.this) == 0)
                {
                  GameInstalledView.b(GameInstalledView.this);
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.uqc);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.upR.setText(this.uqa.title);
      this.upS.setVisibility(8);
      ((View)localObject1).setTag(this.uqa);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (paramView.getTag() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (bt.isNullOrNil(paramView.field_appId)))
      {
        ad.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.f.c.ams(paramView.field_packageName);
        if ((upT.containsKey(paramView.field_appId)) && (((Integer)upT.get(paramView.field_appId)).intValue() > i))
        {
          localObject = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            com.tencent.mm.plugin.downloader.model.f.ccl().tR(((FileDownloadTaskInfo)localObject).id);
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
            if ((i.fv(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.f.c.amt(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              com.tencent.mm.plugin.downloader.model.f.ccl().tR(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.n(paramView.eHt, paramView.eHy, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).aak(paramView.eHt);
            ((g.a)localObject).aam(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).aan(paramView.eHy);
            ((g.a)localObject).jQ(true);
            ((g.a)localObject).Bp(1);
            com.tencent.mm.plugin.downloader.model.f.ccl().a(((g.a)localObject).pmN);
            continue;
            com.tencent.mm.plugin.game.model.e.ai(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.upY, 3, 0, paramView.field_appId, this.udq, 0, null, null, null);
            this.udU.remove(paramView);
            this.udU.addFirst(paramView);
          }
        }
      }
      localObject = com.tencent.mm.plugin.downloader.model.f.ccl().aai(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!bt.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (i.fv(((FileDownloadTaskInfo)localObject).path))) {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          ad.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          com.tencent.mm.plugin.downloader.model.f.ccl().tR(((FileDownloadTaskInfo)localObject).id);
          refresh(false);
        }
      }
      ad.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
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
    if (bt.isNullOrNil(((a)localObject).kwk))
    {
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (int i = 6;; i = com.tencent.mm.plugin.game.f.c.B(this.mContext, ((a)localObject).kwk, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, this.upZ, i, 0, null, this.udq, 0, null, null, null);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.upP = ((LinearLayout)findViewById(2131300473));
    k.a(this.unm);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (bt.hj(this.uqb))
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
      this.udU = com.tencent.mm.plugin.game.model.e.cYz();
      if ((!bt.hj(this.uqb)) && (!bt.hj(this.udU)))
      {
        localObject1 = this.uqb.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.udU.contains(localObject2))
          {
            this.udU.remove(localObject2);
            this.udU.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.udU);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.cYz());
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
      this.udU = ((LinkedList)localObject2);
    }
    cZZ();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.uqb = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.uqa = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.udq = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    upT = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static final class a
  {
    public String iconUrl = "";
    public String kwk = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
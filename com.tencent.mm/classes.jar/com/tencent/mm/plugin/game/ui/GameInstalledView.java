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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static int CXA;
  private static int CXB;
  private static Map<String, Integer> CXy;
  private int CKU;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> CLy;
  private k.a CUR;
  private int CXC;
  private int CXD;
  private int CXE;
  private a CXF;
  private LinkedList<com.tencent.mm.plugin.game.model.c> CXG;
  LinearLayout.LayoutParams CXH;
  private LinearLayout CXu;
  private ImageView CXv;
  private TextView CXw;
  private TextView CXx;
  private final DisplayMetrics CXz;
  private int count;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(42192);
    CXy = new HashMap();
    CXA = 6;
    CXB = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.CLy = new LinkedList();
    this.CXz = new DisplayMetrics();
    this.CXC = 4;
    this.count = 0;
    this.CKU = 0;
    this.CXD = 1;
    this.CXE = 999;
    this.CXH = new LinearLayout.LayoutParams(-1, -2);
    this.CUR = new k.a()
    {
      public final void f(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
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
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evm().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void ezx()
  {
    AppMethodBeat.i(42189);
    if (Util.isNullOrNil(this.CLy))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.CXu.removeAllViews();
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
    if (this.CLy.size() >= this.CXC - 1)
    {
      CXB = 7;
      CXA = 6;
      j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (CXA << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.CXz);
      i = (int)(this.CXz.widthPixels * 160 / this.CXz.densityDpi);
      this.CXC = ((this.CXz.widthPixels - 1) / j + 1);
      if (this.CXC == 3) {
        CXB = 3;
      }
      j = (CXA << 1) + 84;
      k = CXA + 6 + CXB;
      i = (i - 16) % j;
      if (i < k)
      {
        CXA -= 2;
        BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (CXA << 1) + 84);
      }
    }
    else
    {
      this.CXH.setMargins(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, CXA), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, CXA), 0);
      localObject2 = this.CLy.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label704;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(g.f.Coo, null);
      this.CXv = ((ImageView)((View)localObject4).findViewById(g.e.Cjt));
      this.CXw = ((TextView)((View)localObject4).findViewById(g.e.Cke));
      this.CXx = ((TextView)((View)localObject4).findViewById(g.e.Ckp));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.ci.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label586;
      }
      this.CXv.setImageBitmap((Bitmap)localObject5);
      label384:
      this.CXw.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label671;
      }
      i = com.tencent.mm.plugin.game.d.c.aKt(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!CXy.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)CXy.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label612;
      }
      localObject5 = f.cPZ().asZ(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.CXx.setTextColor(this.mContext.getResources().getColor(g.b.CgI));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label599;
      }
      this.CXx.setText(g.i.Cov);
    }
    label671:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.CXu.addView((View)localObject4, this.CXH);
      break label274;
      if (i <= j - k) {
        break;
      }
      CXA = (i - (j >> 1)) / this.CXC + CXA;
      BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, (CXA << 1) + 84);
      break;
      label586:
      this.CXv.setImageResource(g.d.app_panel_unknowed_icon);
      break label384;
      label599:
      this.CXx.setText(g.i.Cou);
      continue;
      label612:
      if (!Util.isNullOrNil(((y)localObject3).hrH))
      {
        this.CXx.setText(((y)localObject3).hrH);
        this.CXx.setTextColor(this.mContext.getResources().getColor(g.b.CgL));
      }
      else
      {
        this.CXx.setText("");
        continue;
        this.CXx.setTextColor(this.mContext.getResources().getColor(g.b.CgI));
        this.CXx.setText(g.i.CoZ);
      }
    }
    label704:
    if ((this.CXF != null) && (this.CXF.iconUrl != null) && (this.CXF.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(g.f.Coo, null);
      this.CXv = ((ImageView)((View)localObject1).findViewById(g.e.Cjt));
      this.CXw = ((TextView)((View)localObject1).findViewById(g.e.Cke));
      this.CXx = ((TextView)((View)localObject1).findViewById(g.e.Ckp));
      localObject2 = q.bml();
      localObject3 = this.CXF.iconUrl;
      localObject4 = this.CXv;
      localObject5 = new c.a();
      ((c.a)localObject5).lRC = true;
      ((com.tencent.mm.ay.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).bmL(), new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
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
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.CXH);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.CXw.setText(this.CXF.title);
      this.CXx.setVisibility(8);
      ((View)localObject1).setTag(this.CXF);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
        i = com.tencent.mm.plugin.game.d.c.aKt(paramView.field_packageName);
        if ((CXy.containsKey(paramView.field_appId)) && (((Integer)CXy.get(paramView.field_appId)).intValue() > i))
        {
          localObject = f.cPZ().asZ(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            f.cPZ().Iw(((FileDownloadTaskInfo)localObject).id);
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
            if ((u.agG(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.d.c.aKv(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              f.cPZ().Iw(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.w(paramView.hrD, paramView.hrI, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).atc(paramView.hrD);
            ((g.a)localObject).ate(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).setFileMD5(paramView.hrI);
            ((g.a)localObject).me(true);
            ((g.a)localObject).IS(1);
            f.cPZ().a(((g.a)localObject).uhY);
            continue;
            com.tencent.mm.plugin.game.model.e.at(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.g.a(this.mContext, 10, 1002, this.CXD, 3, 0, paramView.field_appId, this.CKU, 0, null, null, null);
            this.CLy.remove(paramView);
            this.CLy.addFirst(paramView);
          }
        }
      }
      localObject = f.cPZ().asZ(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!Util.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (u.agG(((FileDownloadTaskInfo)localObject).path))) {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameInstalledView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42191);
          return;
          Log.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          f.cPZ().Iw(((FileDownloadTaskInfo)localObject).id);
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
    if (Util.isNullOrNil(((a)localObject).ozt))
    {
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (int i = 6;; i = com.tencent.mm.plugin.game.d.c.I(this.mContext, ((a)localObject).ozt, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.g.a(this.mContext, 10, 1002, this.CXE, i, 0, null, this.CKU, 0, null, null, null);
      break;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.CXu = ((LinearLayout)findViewById(g.e.Cjy));
    k.a(this.CUR);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (Util.isNullOrNil(this.CXG))
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
      this.CLy = com.tencent.mm.plugin.game.model.e.exX();
      if ((!Util.isNullOrNil(this.CXG)) && (!Util.isNullOrNil(this.CLy)))
      {
        localObject1 = this.CXG.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.CLy.contains(localObject2))
          {
            this.CLy.remove(localObject2);
            this.CLy.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.CLy);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.exX());
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
      this.CLy = ((LinkedList)localObject2);
    }
    ezx();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.CXG = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.CXF = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.CKU = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    CXy = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static class a
  {
    public String iconUrl = "";
    public String ozt = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
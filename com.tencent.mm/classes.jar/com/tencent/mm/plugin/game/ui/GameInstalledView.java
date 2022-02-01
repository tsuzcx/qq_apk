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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.api.d;
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
  private static Map<String, Integer> sjD;
  private static int sjF;
  private static int sjG;
  private int count;
  private Context mContext;
  private int rXI;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.g> rYm;
  private k.a sgV;
  private ImageView sjA;
  private TextView sjB;
  private TextView sjC;
  private final DisplayMetrics sjE;
  private int sjH;
  private int sjI;
  private int sjJ;
  private a sjK;
  private LinkedList<com.tencent.mm.plugin.game.model.c> sjL;
  LinearLayout.LayoutParams sjM;
  private LinearLayout sjz;
  
  static
  {
    AppMethodBeat.i(42192);
    sjD = new HashMap();
    sjF = 6;
    sjG = 7;
    AppMethodBeat.o(42192);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42186);
    this.rYm = new LinkedList();
    this.sjE = new DisplayMetrics();
    this.sjH = 4;
    this.count = 0;
    this.rXI = 0;
    this.sjI = 1;
    this.sjJ = 999;
    this.sjM = new LinearLayout.LayoutParams(-1, -2);
    this.sgV = new k.a()
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
          ((d)com.tencent.mm.kernel.g.ab(d.class)).cBb().init(GameInstalledView.d(GameInstalledView.this));
          GameInstalledView.this.refresh(false);
        }
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(42186);
  }
  
  private void cEk()
  {
    AppMethodBeat.i(42189);
    if (bt.gL(this.rYm))
    {
      setVisibility(8);
      AppMethodBeat.o(42189);
      return;
    }
    setVisibility(0);
    this.sjz.removeAllViews();
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
    if (this.rYm.size() >= this.sjH - 1)
    {
      sjG = 7;
      sjF = 6;
      j = BackwardSupportUtil.b.g(this.mContext, (sjF << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.sjE);
      i = (int)(this.sjE.widthPixels * 160 / this.sjE.densityDpi);
      this.sjH = ((this.sjE.widthPixels - 1) / j + 1);
      if (this.sjH == 3) {
        sjG = 3;
      }
      j = (sjF << 1) + 84;
      k = sjF + 6 + sjG;
      i = (i - 16) % j;
      if (i < k)
      {
        sjF -= 2;
        BackwardSupportUtil.b.g(this.mContext, (sjF << 1) + 84);
      }
    }
    else
    {
      this.sjM.setMargins(BackwardSupportUtil.b.g(this.mContext, sjF), 0, BackwardSupportUtil.b.g(this.mContext, sjF), 0);
      localObject2 = this.rYm.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.sjA = ((ImageView)((View)localObject4).findViewById(2131300462));
      this.sjB = ((TextView)((View)localObject4).findViewById(2131300524));
      this.sjC = ((TextView)((View)localObject4).findViewById(2131300548));
      localObject5 = com.tencent.mm.pluginsdk.model.app.h.c(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId, 1, com.tencent.mm.cd.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.sjA.setImageBitmap((Bitmap)localObject5);
      label380:
      this.sjB.setText(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3, null));
      if (!com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.g)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.f.c.acX(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_packageName);
      if ((!sjD.containsKey(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)) || (((Integer)sjD.get(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = f.bQt().Sp(((com.tencent.mm.pluginsdk.model.app.g)localObject3).field_appId);
      this.sjC.setTextColor(this.mContext.getResources().getColor(2131100436));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.sjC.setText(2131759832);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.sjz.addView((View)localObject4, this.sjM);
      break label274;
      if (i <= j - k) {
        break;
      }
      sjF = (i - (j >> 1)) / this.sjH + sjF;
      BackwardSupportUtil.b.g(this.mContext, (sjF << 1) + 84);
      break;
      label582:
      this.sjA.setImageResource(2131231052);
      break label380;
      label595:
      this.sjC.setText(2131759831);
      continue;
      label608:
      if (!bt.isNullOrNil(((y)localObject3).eok))
      {
        this.sjC.setText(((y)localObject3).eok);
        this.sjC.setTextColor(this.mContext.getResources().getColor(2131100453));
      }
      else
      {
        this.sjC.setText("");
        continue;
        this.sjC.setTextColor(this.mContext.getResources().getColor(2131100436));
        this.sjC.setText(2131759906);
      }
    }
    label700:
    if ((this.sjK != null) && (this.sjK.iconUrl != null) && (this.sjK.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131494485, null);
      this.sjA = ((ImageView)((View)localObject1).findViewById(2131300462));
      this.sjB = ((TextView)((View)localObject1).findViewById(2131300524));
      this.sjC = ((TextView)((View)localObject1).findViewById(2131300548));
      localObject2 = o.ayJ();
      localObject3 = this.sjK.iconUrl;
      localObject4 = this.sjA;
      localObject5 = new c.a();
      ((c.a)localObject5).hjT = true;
      ((com.tencent.mm.aw.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).azc(), new com.tencent.mm.aw.a.c.h()
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
                  GameInstalledView.c(GameInstalledView.this).addView(GameInstalledView.1.this.val$view, GameInstalledView.this.sjM);
                }
                AppMethodBeat.o(42183);
              }
            });
          }
          AppMethodBeat.o(42184);
        }
      });
      this.sjB.setText(this.sjK.title);
      this.sjC.setVisibility(8);
      ((View)localObject1).setTag(this.sjK);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(42189);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42191);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(42191);
      return;
    }
    Object localObject;
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.g))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.g)paramView.getTag();
      if ((paramView == null) || (bt.isNullOrNil(paramView.field_appId)))
      {
        ad.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        AppMethodBeat.o(42191);
        return;
      }
      if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.f.c.acX(paramView.field_packageName);
        if ((sjD.containsKey(paramView.field_appId)) && (((Integer)sjD.get(paramView.field_appId)).intValue() > i))
        {
          localObject = f.bQt().Sp(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            f.bQt().og(((FileDownloadTaskInfo)localObject).id);
          }
        }
        for (;;)
        {
          refresh(false);
          AppMethodBeat.o(42191);
          return;
          if (((FileDownloadTaskInfo)localObject).status == 3)
          {
            if ((i.eK(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.f.c.acY(((FileDownloadTaskInfo)localObject).path) > i)) {
              r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
            } else {
              f.bQt().og(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            k.m(paramView.eog, paramView.eol, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).Sr(paramView.eog);
            ((g.a)localObject).St(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).Su(paramView.eol);
            ((g.a)localObject).jc(true);
            ((g.a)localObject).zO(1);
            f.bQt().a(((g.a)localObject).ofF);
            continue;
            com.tencent.mm.plugin.game.model.e.ai(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, this.sjI, 3, 0, paramView.field_appId, this.rXI, 0, null, null, null);
            this.rYm.remove(paramView);
            this.rYm.addFirst(paramView);
          }
        }
      }
      localObject = f.bQt().Sp(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!bt.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (i.eK(((FileDownloadTaskInfo)localObject).path)))
        {
          r.b(this.mContext, ((FileDownloadTaskInfo)localObject).path, null, false);
          AppMethodBeat.o(42191);
          return;
        }
        ad.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
        f.bQt().og(((FileDownloadTaskInfo)localObject).id);
        refresh(false);
        AppMethodBeat.o(42191);
        return;
      }
      ad.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
      refresh(false);
      AppMethodBeat.o(42191);
      return;
    }
    if ((paramView.getTag() instanceof a))
    {
      localObject = (a)paramView.getTag();
      paramView = new Intent();
      if (!bt.isNullOrNil(((a)localObject).jBp)) {
        break label681;
      }
      paramView.setClass(this.mContext, GameLibraryUI.class);
      paramView.putExtra("game_report_from_scene", 1002);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameInstalledView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    label681:
    for (int i = 6;; i = com.tencent.mm.plugin.game.f.c.A(this.mContext, ((a)localObject).jBp, "game_center_installed_more"))
    {
      com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, this.sjJ, i, 0, null, this.rXI, 0, null, null, null);
      AppMethodBeat.o(42191);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42187);
    super.onFinishInflate();
    this.sjz = ((LinearLayout)findViewById(2131300473));
    k.a(this.sgV);
    AppMethodBeat.o(42187);
  }
  
  public final void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(42188);
    if (bt.gL(this.sjL))
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
      this.rYm = com.tencent.mm.plugin.game.model.e.cCK();
      if ((!bt.gL(this.sjL)) && (!bt.gL(this.rYm)))
      {
        localObject1 = this.sjL.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.rYm.contains(localObject2))
          {
            this.rYm.remove(localObject2);
            this.rYm.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.rYm);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.cCK());
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
        ((LinkedList)localObject2).add(com.tencent.mm.pluginsdk.model.app.h.j(((com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next()).field_appId, true, false));
      }
      this.rYm = ((LinkedList)localObject2);
    }
    cEk();
    AppMethodBeat.o(42188);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.sjL = paramLinkedList;
  }
  
  public void setMoreGameInfo(a parama)
  {
    this.sjK = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(42190);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(42190);
      return;
    }
    sjD = paramMap;
    AppMethodBeat.o(42190);
  }
  
  public static final class a
  {
    public String iconUrl = "";
    public String jBp = "";
    public String title = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
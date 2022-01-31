package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.k.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView
  extends LinearLayout
  implements View.OnClickListener
{
  private static Map<String, Integer> lci = new HashMap();
  private static int lck = 6;
  private static int lcl = 7;
  private int count = 0;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.f> kQN = new LinkedList();
  private int kQh = 0;
  private k.a kZy = new GameInstalledView.2(this);
  private LinearLayout lce;
  private ImageView lcf;
  private TextView lcg;
  private TextView lch;
  private final DisplayMetrics lcj = new DisplayMetrics();
  private int lcm = 4;
  private int lcn = 1;
  private int lco = 999;
  private GameInstalledView.a lcp;
  private LinkedList<com.tencent.mm.plugin.game.model.d> lcq;
  LinearLayout.LayoutParams lcr = new LinearLayout.LayoutParams(-1, -2);
  private Context mContext;
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void bak()
  {
    if (bk.dk(this.kQN)) {
      setVisibility(8);
    }
    label264:
    label374:
    do
    {
      return;
      setVisibility(0);
      this.lce.removeAllViews();
      this.count = 0;
      localObject1 = (LayoutInflater)getContext().getSystemService("layout_inflater");
      int j;
      int i;
      int k;
      if (this.kQN.size() >= this.lcm - 1)
      {
        lcl = 7;
        lck = 6;
        j = BackwardSupportUtil.b.b(this.mContext, (lck << 1) + 84);
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.lcj);
        i = (int)(this.lcj.widthPixels * 160 / this.lcj.densityDpi);
        this.lcm = ((this.lcj.widthPixels - 1) / j + 1);
        if (this.lcm == 3) {
          lcl = 3;
        }
        j = (lck << 1) + 84;
        k = lck + 6 + lcl;
        i = (i - 16) % j;
        if (i < k)
        {
          lck -= 2;
          BackwardSupportUtil.b.b(this.mContext, (lck << 1) + 84);
        }
      }
      else
      {
        this.lcr.setMargins(BackwardSupportUtil.b.b(this.mContext, lck), 0, BackwardSupportUtil.b.b(this.mContext, lck), 0);
        localObject2 = this.kQN.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject3 = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject2).next();
        localObject4 = ((LayoutInflater)localObject1).inflate(g.f.installed_game_item, null);
        this.lcf = ((ImageView)((View)localObject4).findViewById(g.e.game_icon));
        this.lcg = ((TextView)((View)localObject4).findViewById(g.e.game_name));
        this.lch = ((TextView)((View)localObject4).findViewById(g.e.game_sns_info));
        localObject5 = g.b(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
        if (localObject5 == null) {
          break label576;
        }
        this.lcf.setImageBitmap((Bitmap)localObject5);
        this.lcg.setText(g.b(this.mContext, (com.tencent.mm.pluginsdk.model.app.f)localObject3, null));
        if (!g.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.f)localObject3)) {
          break label661;
        }
        i = c.Fe(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName);
        if ((!lci.containsKey(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId)) || (((Integer)lci.get(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId)).intValue() <= i)) {
          break label602;
        }
        localObject5 = com.tencent.mm.plugin.downloader.model.d.aFP().zL(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId);
        this.lch.setTextColor(this.mContext.getResources().getColor(g.b.gc_install_text_color));
        if (((FileDownloadTaskInfo)localObject5).status != 1) {
          break label589;
        }
        this.lch.setText(g.i.game_action_updating);
      }
      for (;;)
      {
        ((View)localObject4).setTag(localObject3);
        ((View)localObject4).setOnClickListener(this);
        this.lce.addView((View)localObject4, this.lcr);
        break label264;
        if (i <= j - k) {
          break;
        }
        lck = (i - (j >> 1)) / this.lcm + lck;
        BackwardSupportUtil.b.b(this.mContext, (lck << 1) + 84);
        break;
        this.lcf.setImageResource(g.d.app_panel_unknowed_icon);
        break label374;
        this.lch.setText(g.i.game_action_update);
        continue;
        if (!bk.bl(((r)localObject3).cvC))
        {
          this.lch.setText(((r)localObject3).cvC);
          this.lch.setTextColor(this.mContext.getResources().getColor(g.b.gc_sns_info_color));
        }
        else
        {
          this.lch.setText("");
          continue;
          this.lch.setTextColor(this.mContext.getResources().getColor(g.b.gc_install_text_color));
          this.lch.setText(g.i.game_list_app_install);
        }
      }
    } while ((this.lcp == null) || (this.lcp.iconUrl == null) || (this.lcp.title == null));
    label576:
    label589:
    label602:
    Object localObject1 = ((LayoutInflater)localObject1).inflate(g.f.installed_game_item, null);
    label661:
    this.lcf = ((ImageView)((View)localObject1).findViewById(g.e.game_icon));
    this.lcg = ((TextView)((View)localObject1).findViewById(g.e.game_name));
    this.lch = ((TextView)((View)localObject1).findViewById(g.e.game_sns_info));
    Object localObject2 = o.ON();
    Object localObject3 = this.lcp.iconUrl;
    Object localObject4 = this.lcf;
    Object localObject5 = new c.a();
    ((c.a)localObject5).ere = true;
    ((com.tencent.mm.as.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).OV(), new GameInstalledView.1(this, (View)localObject1));
    this.lcg.setText(this.lcp.title);
    this.lch.setVisibility(8);
    ((View)localObject1).setTag(this.lcp);
    ((View)localObject1).setOnClickListener(this);
  }
  
  public final void fD(boolean paramBoolean)
  {
    if (bk.dk(this.lcq))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      this.kQN = com.tencent.mm.plugin.game.model.f.aYS();
      if ((!bk.dk(this.lcq)) && (!bk.dk(this.kQN)))
      {
        localObject1 = this.lcq.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.d)((Iterator)localObject1).next();
          if (this.kQN.contains(localObject2))
          {
            this.kQN.remove(localObject2);
            this.kQN.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.kQN);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.f.aYS());
      localObject2 = new LinkedList();
      Object localObject4 = ((LinkedList)localObject1).iterator();
      com.tencent.mm.pluginsdk.model.app.f localf;
      while (((Iterator)localObject4).hasNext())
      {
        localf = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject4).next();
        if ((!((LinkedList)localObject3).contains(localf)) && (!((LinkedList)localObject2).contains(localf))) {
          ((LinkedList)localObject2).add(localf);
        }
      }
      localObject4 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localf = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject4).next();
        if (((LinkedList)localObject3).contains(localf)) {
          ((LinkedList)localObject3).remove(localf);
        } else if (!g.a(this.mContext, localf)) {
          ((LinkedList)localObject2).add(localf);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject3).next();
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
        ((LinkedList)localObject2).add(g.by(((com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject1).next()).field_appId, true));
      }
      this.kQN = ((LinkedList)localObject2);
    }
    bak();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      return;
      if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.f))
      {
        paramView = (com.tencent.mm.pluginsdk.model.app.f)paramView.getTag();
        if ((paramView == null) || (bk.bl(paramView.field_appId)))
        {
          y.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
          return;
        }
        if (g.a(this.mContext, paramView))
        {
          i = c.Fe(paramView.field_packageName);
          if ((lci.containsKey(paramView.field_appId)) && (((Integer)lci.get(paramView.field_appId)).intValue() > i))
          {
            localObject = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramView.field_appId);
            if (((FileDownloadTaskInfo)localObject).status == 1) {
              com.tencent.mm.plugin.downloader.model.d.aFP().dc(((FileDownloadTaskInfo)localObject).id);
            }
          }
          for (;;)
          {
            fD(false);
            return;
            if (((FileDownloadTaskInfo)localObject).status == 3)
            {
              if ((e.bK(((FileDownloadTaskInfo)localObject).path)) && (c.Ff(((FileDownloadTaskInfo)localObject).path) > i))
              {
                paramView = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject).path));
                q.g(this.mContext, paramView);
              }
              else
              {
                com.tencent.mm.plugin.downloader.model.d.aFP().dc(((FileDownloadTaskInfo)localObject).id);
              }
            }
            else
            {
              k.l(paramView.cvy, paramView.cvD, paramView.field_appId, "");
              localObject = new e.a();
              ((e.a)localObject).zN(paramView.cvy);
              ((e.a)localObject).zP(g.b(this.mContext, paramView, null));
              ((e.a)localObject).setAppId(paramView.field_appId);
              ((e.a)localObject).zQ(paramView.cvD);
              ((e.a)localObject).eO(true);
              ((e.a)localObject).pE(1);
              com.tencent.mm.plugin.downloader.model.d.aFP().a(((e.a)localObject).iPG);
              continue;
              com.tencent.mm.plugin.game.model.f.ai(this.mContext, paramView.field_appId);
              b.a(this.mContext, 10, 1002, this.lcn, 3, 0, paramView.field_appId, this.kQh, 0, null, null, null);
              this.kQN.remove(paramView);
              this.kQN.addFirst(paramView);
            }
          }
        }
        localObject = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramView.field_appId);
        if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
        {
          if ((!bk.bl(((FileDownloadTaskInfo)localObject).path)) && (e.bK(((FileDownloadTaskInfo)localObject).path)))
          {
            paramView = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject).path));
            q.g(this.mContext, paramView);
            return;
          }
          y.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
          com.tencent.mm.plugin.downloader.model.d.aFP().dc(((FileDownloadTaskInfo)localObject).id);
          fD(false);
          return;
        }
        y.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
        fD(false);
        return;
      }
    } while (!(paramView.getTag() instanceof GameInstalledView.a));
    paramView = (GameInstalledView.a)paramView.getTag();
    Object localObject = new Intent();
    int i = 6;
    if (bk.bl(paramView.gis))
    {
      ((Intent)localObject).setClass(this.mContext, GameLibraryUI.class);
      ((Intent)localObject).putExtra("game_report_from_scene", 1002);
      this.mContext.startActivity((Intent)localObject);
    }
    for (;;)
    {
      b.a(this.mContext, 10, 1002, this.lco, i, 0, null, this.kQh, 0, null, null, null);
      return;
      i = c.o(this.mContext, paramView.gis, "game_center_installed_more");
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.lce = ((LinearLayout)findViewById(g.e.game_installed_layout));
    k.a(this.kZy);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.d> paramLinkedList)
  {
    this.lcq = paramLinkedList;
  }
  
  public void setMoreGameInfo(GameInstalledView.a parama)
  {
    this.lcp = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    lci = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
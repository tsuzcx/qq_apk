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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static Map<String, Integer> nAd;
  private static int nAf;
  private static int nAg;
  private int count;
  private Context mContext;
  private ImageView nAa;
  private TextView nAb;
  private TextView nAc;
  private final DisplayMetrics nAe;
  private int nAh;
  private int nAi;
  private int nAj;
  private GameInstalledView.a nAk;
  private LinkedList<com.tencent.mm.plugin.game.model.c> nAl;
  LinearLayout.LayoutParams nAm;
  private LinkedList<com.tencent.mm.pluginsdk.model.app.f> noR;
  private int nok;
  private j.a nxv;
  private LinearLayout nzZ;
  
  static
  {
    AppMethodBeat.i(112005);
    nAd = new HashMap();
    nAf = 6;
    nAg = 7;
    AppMethodBeat.o(112005);
  }
  
  public GameInstalledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111999);
    this.noR = new LinkedList();
    this.nAe = new DisplayMetrics();
    this.nAh = 4;
    this.count = 0;
    this.nok = 0;
    this.nAi = 1;
    this.nAj = 999;
    this.nAm = new LinearLayout.LayoutParams(-1, -2);
    this.nxv = new GameInstalledView.2(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111999);
  }
  
  private void bHp()
  {
    AppMethodBeat.i(112002);
    if (bo.es(this.noR))
    {
      setVisibility(8);
      AppMethodBeat.o(112002);
      return;
    }
    setVisibility(0);
    this.nzZ.removeAllViews();
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
    if (this.noR.size() >= this.nAh - 1)
    {
      nAg = 7;
      nAf = 6;
      j = BackwardSupportUtil.b.b(this.mContext, (nAf << 1) + 84);
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.nAe);
      i = (int)(this.nAe.widthPixels * 160 / this.nAe.densityDpi);
      this.nAh = ((this.nAe.widthPixels - 1) / j + 1);
      if (this.nAh == 3) {
        nAg = 3;
      }
      j = (nAf << 1) + 84;
      k = nAf + 6 + nAg;
      i = (i - 16) % j;
      if (i < k)
      {
        nAf -= 2;
        BackwardSupportUtil.b.b(this.mContext, (nAf << 1) + 84);
      }
    }
    else
    {
      this.nAm.setMargins(BackwardSupportUtil.b.b(this.mContext, nAf), 0, BackwardSupportUtil.b.b(this.mContext, nAf), 0);
      localObject2 = this.noR.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label700;
      }
      localObject3 = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject2).next();
      localObject4 = ((LayoutInflater)localObject1).inflate(2130969907, null);
      this.nAa = ((ImageView)((View)localObject4).findViewById(2131821573));
      this.nAb = ((TextView)((View)localObject4).findViewById(2131821575));
      this.nAc = ((TextView)((View)localObject4).findViewById(2131825148));
      localObject5 = g.b(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if (localObject5 == null) {
        break label582;
      }
      this.nAa.setImageBitmap((Bitmap)localObject5);
      label380:
      this.nAb.setText(g.b(this.mContext, (com.tencent.mm.pluginsdk.model.app.f)localObject3, null));
      if (!g.a(this.mContext, (com.tencent.mm.pluginsdk.model.app.f)localObject3)) {
        break label667;
      }
      i = com.tencent.mm.plugin.game.f.c.Qy(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName);
      if ((!nAd.containsKey(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId)) || (((Integer)nAd.get(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId)).intValue() <= i)) {
        break label608;
      }
      localObject5 = com.tencent.mm.plugin.downloader.model.f.bjl().JH(((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appId);
      this.nAc.setTextColor(this.mContext.getResources().getColor(2131690111));
      if (((FileDownloadTaskInfo)localObject5).status != 1) {
        break label595;
      }
      this.nAc.setText(2131300333);
    }
    label667:
    for (;;)
    {
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      this.nzZ.addView((View)localObject4, this.nAm);
      break label274;
      if (i <= j - k) {
        break;
      }
      nAf = (i - (j >> 1)) / this.nAh + nAf;
      BackwardSupportUtil.b.b(this.mContext, (nAf << 1) + 84);
      break;
      label582:
      this.nAa.setImageResource(2130837799);
      break label380;
      label595:
      this.nAc.setText(2131300332);
      continue;
      label608:
      if (!bo.isNullOrNil(((t)localObject3).djN))
      {
        this.nAc.setText(((t)localObject3).djN);
        this.nAc.setTextColor(this.mContext.getResources().getColor(2131690128));
      }
      else
      {
        this.nAc.setText("");
        continue;
        this.nAc.setTextColor(this.mContext.getResources().getColor(2131690111));
        this.nAc.setText(2131300397);
      }
    }
    label700:
    if ((this.nAk != null) && (this.nAk.iconUrl != null) && (this.nAk.title != null))
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2130969907, null);
      this.nAa = ((ImageView)((View)localObject1).findViewById(2131821573));
      this.nAb = ((TextView)((View)localObject1).findViewById(2131821575));
      this.nAc = ((TextView)((View)localObject1).findViewById(2131825148));
      localObject2 = o.ahG();
      localObject3 = this.nAk.iconUrl;
      localObject4 = this.nAa;
      localObject5 = new c.a();
      ((c.a)localObject5).eNL = true;
      ((com.tencent.mm.at.a.a)localObject2).a((String)localObject3, (ImageView)localObject4, ((c.a)localObject5).ahY(), new GameInstalledView.1(this, (View)localObject1));
      this.nAb.setText(this.nAk.title);
      this.nAc.setVisibility(8);
      ((View)localObject1).setTag(this.nAk);
      ((View)localObject1).setOnClickListener(this);
    }
    AppMethodBeat.o(112002);
  }
  
  public final void hf(boolean paramBoolean)
  {
    AppMethodBeat.i(112001);
    if (bo.es(this.nAl))
    {
      setVisibility(8);
      AppMethodBeat.o(112001);
      return;
    }
    setVisibility(0);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      this.noR = com.tencent.mm.plugin.game.model.e.bFR();
      if ((!bo.es(this.nAl)) && (!bo.es(this.noR)))
      {
        localObject1 = this.nAl.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.model.c)((Iterator)localObject1).next();
          if (this.noR.contains(localObject2))
          {
            this.noR.remove(localObject2);
            this.noR.addFirst(localObject2);
          }
        }
      }
    }
    else
    {
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).addAll(this.noR);
      Object localObject3 = new LinkedList();
      ((LinkedList)localObject3).addAll(com.tencent.mm.plugin.game.model.e.bFR());
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
        ((LinkedList)localObject2).add(g.ca(((com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject1).next()).field_appId, true));
      }
      this.noR = ((LinkedList)localObject2);
    }
    bHp();
    AppMethodBeat.o(112001);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112004);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(112004);
      return;
    }
    int i;
    Object localObject;
    if ((paramView.getTag() instanceof com.tencent.mm.pluginsdk.model.app.f))
    {
      paramView = (com.tencent.mm.pluginsdk.model.app.f)paramView.getTag();
      if ((paramView == null) || (bo.isNullOrNil(paramView.field_appId)))
      {
        ab.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
        AppMethodBeat.o(112004);
        return;
      }
      if (g.a(this.mContext, paramView))
      {
        i = com.tencent.mm.plugin.game.f.c.Qy(paramView.field_packageName);
        if ((nAd.containsKey(paramView.field_appId)) && (((Integer)nAd.get(paramView.field_appId)).intValue() > i))
        {
          localObject = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramView.field_appId);
          if (((FileDownloadTaskInfo)localObject).status == 1) {
            com.tencent.mm.plugin.downloader.model.f.bjl().iz(((FileDownloadTaskInfo)localObject).id);
          }
        }
        for (;;)
        {
          hf(false);
          AppMethodBeat.o(112004);
          return;
          if (((FileDownloadTaskInfo)localObject).status == 3)
          {
            if ((com.tencent.mm.vfs.e.cN(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.plugin.game.f.c.Qz(((FileDownloadTaskInfo)localObject).path) > i))
            {
              paramView = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject).path));
              q.a(this.mContext, paramView, null);
            }
            else
            {
              com.tencent.mm.plugin.downloader.model.f.bjl().iz(((FileDownloadTaskInfo)localObject).id);
            }
          }
          else
          {
            j.n(paramView.djJ, paramView.djO, paramView.field_appId, "");
            localObject = new g.a();
            ((g.a)localObject).JJ(paramView.djJ);
            ((g.a)localObject).JL(g.b(this.mContext, paramView, null));
            ((g.a)localObject).setAppId(paramView.field_appId);
            ((g.a)localObject).JM(paramView.djO);
            ((g.a)localObject).gr(true);
            ((g.a)localObject).tV(1);
            com.tencent.mm.plugin.downloader.model.f.bjl().a(((g.a)localObject).kYR);
            continue;
            com.tencent.mm.plugin.game.model.e.aj(this.mContext, paramView.field_appId);
            com.tencent.mm.game.report.c.a(this.mContext, 10, 1002, this.nAi, 3, 0, paramView.field_appId, this.nok, 0, null, null, null);
            this.noR.remove(paramView);
            this.noR.addFirst(paramView);
          }
        }
      }
      localObject = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramView.field_appId);
      if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 3))
      {
        if ((!bo.isNullOrNil(((FileDownloadTaskInfo)localObject).path)) && (com.tencent.mm.vfs.e.cN(((FileDownloadTaskInfo)localObject).path)))
        {
          paramView = Uri.fromFile(new File(((FileDownloadTaskInfo)localObject).path));
          q.a(this.mContext, paramView, null);
          AppMethodBeat.o(112004);
          return;
        }
        ab.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[] { ((FileDownloadTaskInfo)localObject).path });
        com.tencent.mm.plugin.downloader.model.f.bjl().iz(((FileDownloadTaskInfo)localObject).id);
        hf(false);
        AppMethodBeat.o(112004);
        return;
      }
      ab.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[] { paramView.field_appName });
      hf(false);
      AppMethodBeat.o(112004);
      return;
    }
    if ((paramView.getTag() instanceof GameInstalledView.a))
    {
      paramView = (GameInstalledView.a)paramView.getTag();
      localObject = new Intent();
      i = 6;
      if (!bo.isNullOrNil(paramView.hBM)) {
        break label634;
      }
      ((Intent)localObject).setClass(this.mContext, GameLibraryUI.class);
      ((Intent)localObject).putExtra("game_report_from_scene", 1002);
      this.mContext.startActivity((Intent)localObject);
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.mContext, 10, 1002, this.nAj, i, 0, null, this.nok, 0, null, null, null);
      AppMethodBeat.o(112004);
      return;
      label634:
      i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView.hBM, "game_center_installed_more");
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112000);
    super.onFinishInflate();
    this.nzZ = ((LinearLayout)findViewById(2131824525));
    j.a(this.nxv);
    AppMethodBeat.o(112000);
  }
  
  public void setInstalledGameInfo(LinkedList<com.tencent.mm.plugin.game.model.c> paramLinkedList)
  {
    this.nAl = paramLinkedList;
  }
  
  public void setMoreGameInfo(GameInstalledView.a parama)
  {
    this.nAk = parama;
  }
  
  public void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
  
  public void setVersionCodes(Map<String, Integer> paramMap)
  {
    AppMethodBeat.i(112003);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(112003);
      return;
    }
    nAd = paramMap;
    AppMethodBeat.o(112003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView
 * JD-Core Version:    0.7.0.1
 */
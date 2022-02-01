package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSBaseMainUI;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.c;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.f;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfj;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public final class k
  implements View.OnFocusChangeListener, com.tencent.mm.am.h
{
  public FTSBaseMainUI HDH;
  private final int HDQ;
  public View HDR;
  private int HDS;
  private int HDT;
  private int HDU;
  public View HDV;
  public TextView HDW;
  public TextView HDX;
  public TextView HDY;
  public View HDZ;
  public boolean HEA;
  public boolean HEB;
  public boolean HEC;
  private boolean HED;
  public MMHandler HEE;
  private u HEF;
  private long HEG;
  private long HEH;
  private View.OnClickListener HEI;
  private View.OnClickListener HEJ;
  public TextView HEK;
  private ImageView HEL;
  private IListener<ox> HEM;
  public View HEa;
  public View HEb;
  public TextView HEc;
  public TextView HEd;
  public TextView HEe;
  public View HEf;
  public ImageView HEg;
  public TextView HEh;
  public TextView HEi;
  public TextView HEj;
  public TextView HEk;
  public View HEl;
  public ImageView HEm;
  public TextView HEn;
  public TextView HEo;
  public TextView HEp;
  public View HEq;
  public ImageView HEr;
  public ImageView HEs;
  public TextView HEt;
  public TextView HEu;
  public TextView HEv;
  public l HEw;
  public v HEx;
  public b HEy;
  public boolean HEz;
  public long HxE;
  public int Hxo;
  private View Hyn;
  private View Hyo;
  public View Hyp;
  private View Hyq;
  public LinearLayout Hyr;
  public TextView Hys;
  private TextView Hyt;
  private ebb Hyu;
  public long Hyw;
  public View contentView;
  public ImageView lBC;
  public String query;
  private long teM;
  
  public k(FTSBaseMainUI paramFTSBaseMainUI)
  {
    AppMethodBeat.i(265867);
    this.HDQ = 3;
    this.HDS = 0;
    this.HDT = 0;
    this.HDU = 0;
    this.HEy = b.HER;
    this.HEz = false;
    this.HEA = false;
    this.HEB = false;
    this.HEC = false;
    this.HED = false;
    this.Hxo = 1;
    this.HEE = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(112332);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112332);
          return;
          if (paramAnonymousMessage.obj.equals(Long.valueOf(k.a(k.this))))
          {
            Log.i("MicroMsg.FTS.PardusSearchLogic", "timeout, show footer view first");
            k.this.dBz();
          }
        }
      }
    };
    this.HEH = 60L;
    this.HEI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = (aqp)paramAnonymousView.getTag();
        k.this.P(paramAnonymousView.ZxJ.abiz, 22, paramAnonymousView.ZxJ.abgw);
        k.b(k.this).HxP.HyQ = true;
        com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), 1, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 28, "", "", "");
        k.b(k.this).HxP.HyV.Wq(28);
        k.a(k.this, 0, "", "", "", paramAnonymousView.ZxJ.abgw, paramAnonymousView.crs + 1, "");
        k.this.Wu(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112336);
      }
    };
    this.HEJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousView = (te)paramAnonymousView.getTag();
        switch (paramAnonymousView.vhJ)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!k.d(k.this)) {
          j = 1;
        }
        localObject1 = (eax)paramAnonymousView.YYN.getFirst();
        Object localObject2 = ((eax)localObject1).abgs;
        k.this.a((eay)localObject2);
        int i;
        if (paramAnonymousView.vhJ == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject1).abgr.hAP);
          com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), j, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, i + "$" + (String)localObject2, ((eax)localObject1).abgr.abgw, "");
          k.b(k.this).HxP.HyV.Wq(27);
          k.a(k.this, paramAnonymousView.vhJ, ((eax)localObject1).abgr.abgw, (String)localObject2, "", "", 0, "");
          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject2, ((eax)localObject1).abgr.abgw });
          break;
          if (paramAnonymousView.vhJ == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.HEM = new PardusSearchLogic.12(this, com.tencent.mm.app.f.hfK);
    this.HDH = paramFTSBaseMainUI;
    this.HDS = (com.tencent.mm.cd.a.ms(paramFTSBaseMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSBaseMainUI.getContext(), 100));
    this.HDT = (com.tencent.mm.cd.a.ms(paramFTSBaseMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSBaseMainUI.getContext(), 116));
    this.HDU = (com.tencent.mm.cd.a.ms(paramFTSBaseMainUI.getContext()) - com.tencent.mm.cd.a.fromDPToPix(paramFTSBaseMainUI.getContext(), 48));
    fzA();
    AppMethodBeat.o(265867);
  }
  
  public static com.tencent.mm.aw.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Zpr == null) || (paramTimeLineObject.ContentObj.Zpr.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    dmz localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
    if (localdmz == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.aw.f localf = new com.tencent.mm.aw.f();
    localf.oOt = 9;
    localf.oOv = paramString2;
    localf.oOw = 0.0F;
    localf.oOz = "";
    if (!TextUtils.isEmpty(localdmz.songAlbumUrl)) {
      localf.oOM = localdmz.songAlbumUrl;
    }
    localf.oOA = localdmz.aaTl;
    localf.oOF = null;
    localf.oOu = 1;
    localf.oOE = localdmz.songLyric;
    localf.oOx = localdmz.hAP;
    localf.oOy = localdmz.IGG;
    paramString2 = localObject;
    if (paramTimeLineObject.ContentObj != null) {
      paramString2 = paramTimeLineObject.ContentObj.Url;
    }
    localf.oOD = paramString2;
    localf.oOC = localdmz.aaTo;
    localf.oOB = localdmz.Url;
    localf.oOJ = localdmz.aaTm;
    localf.oOL = localdmz.Id;
    localf.oOG = paramString1;
    localf.oOI = paramTimeLineObject.AppInfo.Id;
    localf.oOP = paramTimeLineObject.UserName;
    localf.oOW = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void fzA()
  {
    AppMethodBeat.i(112355);
    if ((System.currentTimeMillis() - this.HEG > this.HEH * 1000L) && (!aj.aBu()))
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      fzB();
      this.HEF = new u(new eav());
      com.tencent.mm.kernel.h.aZW().a(1417, this);
      com.tencent.mm.kernel.h.aZW().a(this.HEF, 0);
      this.HEG = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  private void fzD()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.Hyu == null) || (this.Hyu.aaLt == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label524;
      }
      this.HEA = true;
      this.HDV.setVisibility(0);
      j = ((fkk)((List)localObject1).get(0)).abiz.length() + 0;
      localObject2 = new aqp();
      ((aqp)localObject2).ZxJ = ((fkk)((List)localObject1).get(0));
      ((aqp)localObject2).crs = 0;
      this.HDW.setTag(localObject2);
      this.HDW.setText(((fkk)((List)localObject1).get(0)).abiz);
      this.HDW.setOnClickListener(this.HEI);
      this.HDW.setVisibility(0);
      this.HDH.HxP.HyV.L(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label486;
      }
      j += ((fkk)((List)localObject1).get(1)).abiz.length();
      this.HDX.setOnClickListener(this.HEI);
      localObject2 = new aqp();
      ((aqp)localObject2).ZxJ = ((fkk)((List)localObject1).get(1));
      ((aqp)localObject2).crs = 1;
      this.HDX.setTag(localObject2);
      this.HDX.setText(((fkk)((List)localObject1).get(1)).abiz);
      this.HDX.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label512;
      }
      if (((fkk)((List)localObject1).get(2)).abiz.length() + j > 24) {
        break label500;
      }
      this.HDY.setOnClickListener(this.HEI);
      localObject2 = new aqp();
      ((aqp)localObject2).ZxJ = ((fkk)((List)localObject1).get(2));
      ((aqp)localObject2).crs = 2;
      this.HDY.setTag(localObject2);
      this.HDY.setText(((fkk)((List)localObject1).get(2)).abiz);
      this.HDY.setVisibility(0);
      i += 1;
    }
    label512:
    label524:
    for (;;)
    {
      label405:
      if (this.HEA)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((fkk)((List)localObject1).get(j)).abgw + "_";
            j += 1;
            continue;
            localObject1 = this.Hyu.aaLt.YIB;
            break;
            label486:
            this.HDX.setVisibility(8);
            i = 1;
            break label286;
            label500:
            this.HDY.setVisibility(8);
            break label405;
            this.HDY.setVisibility(8);
            break label405;
            this.HDV.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        g(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.HEA) {
      k = 1;
    }
    if (this.Hyu.abgB.size() > 0) {}
    for (te localte = (te)this.Hyu.abgB.getFirst();; localte = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localte != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.HEa.setTag(localte);
        switch (localte.vhJ)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localte.vhJ)
          {
          default: 
            this.HDZ.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label788:
            this.HEa.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                k.this.fk(k.c(k.this), 21);
                te localte = (te)paramAnonymousView.getTag();
                paramAnonymousView = "";
                localObject = "";
                String str1;
                String str2;
                switch (localte.vhJ)
                {
                default: 
                  str1 = "";
                  str2 = "";
                }
                for (;;)
                {
                  int i = 2;
                  if (!k.d(k.this)) {
                    i = 1;
                  }
                  com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 2, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, paramAnonymousView, (String)localObject, "");
                  k.b(k.this).HxP.HyV.Wq(27);
                  k.b(k.this).HxP.HyQ = true;
                  k.a(k.this, localte.vhJ, "more", str2, str1, "", 0, "");
                  k.this.Wu(5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (qx)localte.YYH.getFirst();
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((qx)localObject).YVQ.hAP);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((qx)localObject).YVQ.abgw;
                  str1 = "";
                  continue;
                  localObject = (gfj)localte.YYI.getFirst();
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((gfj)localObject).YVQ.hAP);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((gfj)localObject).YVQ.abgw;
                  str1 = "";
                  continue;
                  localObject = (akt)localte.YYJ.getFirst();
                  str1 = ((akt)localObject).IGI;
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((akt)localObject).YVQ.hAP);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((akt)localObject).YVQ.abgw;
                  continue;
                  localObject = (eax)localte.YYN.getFirst();
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject).abgr.hAP);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((eax)localObject).abgr.abgw;
                  str1 = "";
                  continue;
                  localObject = (eax)localte.YYN.getFirst();
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject).abgr.hAP);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((eax)localObject).abgr.abgw;
                  str1 = "";
                  continue;
                  localObject = (eax)localte.YYN.getFirst();
                  str2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject).abgr.hAP);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((eax)localObject).abgr.abgw;
                  str1 = "";
                }
              }
            });
            this.HEb.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112339);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
                if (!k.d(k.this)) {}
                for (int i = 1;; i = 2) {
                  try
                  {
                    paramAnonymousView = (te)paramAnonymousView.getTag();
                    if (paramAnonymousView.vhJ == 64)
                    {
                      localObject1 = (gfj)paramAnonymousView.YYI.getFirst();
                      localObject2 = new zp();
                      ((zp)localObject2).icM.userName = ((gfj)localObject1).UserName;
                      ((zp)localObject2).icM.scene = 1027;
                      ((zp)localObject2).icM.hzx = "2";
                      ((zp)localObject2).publish();
                      localObject2 = com.tencent.mm.plugin.fts.ui.l.aEL(((gfj)localObject1).YVQ.hAP);
                      com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, "2$".concat(String.valueOf(localObject2)), ((gfj)localObject1).YVQ.abgw, ((gfj)localObject1).UserName);
                      k.b(k.this).HxP.HyV.Wq(27);
                      k.a(k.this, paramAnonymousView.vhJ, ((gfj)localObject1).YVQ.abgw, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((gfj)localObject1).UserName, ((gfj)localObject1).YVQ.abgw });
                      k.this.Wu(4);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(112339);
                      return;
                    }
                    if (paramAnonymousView.vhJ == 1)
                    {
                      localObject1 = (qx)paramAnonymousView.YYH.getFirst();
                      localObject2 = new JSONObject(((qx)localObject1).YVR);
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                      ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                      ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                      ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                      ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                      ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                      ((Intent)localObject3).putExtra("Contact_Scene", 3);
                      localObject4 = new ahl();
                      ((ahl)localObject4).pSt = ((JSONObject)localObject2).optInt("brandFlag", 0);
                      ((ahl)localObject4).pSw = ((JSONObject)localObject2).optString("iconUrl", "");
                      ((ahl)localObject4).pSv = ((JSONObject)localObject2).optString("brandInfo", "");
                      ((ahl)localObject4).pSu = ((JSONObject)localObject2).optString("externalInfo", "");
                    }
                  }
                  catch (Exception paramAnonymousView)
                  {
                    try
                    {
                      label522:
                      do
                      {
                        for (;;)
                        {
                          ((Intent)localObject3).putExtra("Contact_customInfo", ((ahl)localObject4).toByteArray());
                          Object localObject4 = new Bundle();
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(k.a(k.this)));
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", k.c(k.this));
                          ((Bundle)localObject4).putInt("Contact_Scene", 3);
                          ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                          ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                          ((Intent)localObject3).putExtra("preChatTYPE", 10);
                          ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                          com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                          Object localObject3 = com.tencent.mm.plugin.fts.ui.l.aEL(((qx)localObject1).YVQ.hAP);
                          com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, "1$".concat(String.valueOf(localObject3)), ((qx)localObject1).YVQ.abgw, "");
                          k.this.Wu(4);
                          k.b(k.this).HxP.HyV.Wq(27);
                          k.b(k.this).HxP.HyQ = true;
                          k.a(k.this, paramAnonymousView.vhJ, ((qx)localObject1).YVQ.abgw, (String)localObject3, "", "", 0, "");
                          Log.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((qx)localObject1).YVQ.abgw });
                          continue;
                          paramAnonymousView = paramAnonymousView;
                          Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                        }
                      } while (paramAnonymousView.vhJ != 5);
                      localObject1 = (eax)paramAnonymousView.YYN.getFirst();
                      Object localObject2 = ((eax)localObject1).abgs;
                      k.this.a((eay)localObject2);
                      localObject2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject1).abgr.hAP);
                      com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, "8$".concat(String.valueOf(localObject2)), ((eax)localObject1).abgr.abgw, "");
                      k.b(k.this).HxP.HyV.Wq(27);
                      k.a(k.this, paramAnonymousView.vhJ, ((eax)localObject1).abgr.abgw, (String)localObject2, "", "", 0, "");
                      Log.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((eax)localObject1).abgr.abgw });
                    }
                    catch (IOException localIOException)
                    {
                      break label522;
                    }
                  }
                }
              }
            });
            this.HEf.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
                int i = 2;
                if (!k.d(k.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (te)paramAnonymousView.getTag();
                    localObject1 = (akt)paramAnonymousView.YYJ.getFirst();
                    if (((akt)localObject1).IHl != 1) {
                      continue;
                    }
                    localObject2 = new zp();
                    ((zp)localObject2).icM.userName = ((akt)localObject1).UserName;
                    ((zp)localObject2).icM.icO = ((akt)localObject1).ZrY;
                    ((zp)localObject2).icM.appVersion = ((akt)localObject1).ZrZ;
                    ((zp)localObject2).icM.scene = 1027;
                    ((zp)localObject2).icM.hzx = (((akt)localObject1).Zsa + ":2");
                    ((zp)localObject2).publish();
                    localObject2 = com.tencent.mm.plugin.fts.ui.l.aEL(((akt)localObject1).YVQ.hAP);
                    com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, "4$".concat(String.valueOf(localObject2)), ((akt)localObject1).YVQ.abgw, "");
                    k.this.Wu(4);
                    k.b(k.this).HxP.HyV.Wq(27);
                    k.b(k.this).HxP.HyQ = true;
                    k.a(k.this, paramAnonymousView.vhJ, ((akt)localObject1).YVQ.abgw, (String)localObject2, ((akt)localObject1).IGI, "", 0, "");
                    Log.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { ((akt)localObject1).YVQ.abgw });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    Object localObject2;
                    Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  k.this.Wu(4);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112340);
                  return;
                  if (((akt)localObject1).IHl == 0)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("rawUrl", ((akt)localObject1).IGI);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject2);
                  }
                }
              }
            });
            this.HEr.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
                int i = 2;
                if (!k.d(k.this)) {
                  i = 1;
                }
                paramAnonymousView = (te)paramAnonymousView.getTag();
                localObject1 = (eax)paramAnonymousView.YYN.getFirst();
                Object localObject2 = ((eax)localObject1).abgr.abgw;
                if (com.tencent.mm.aw.a.bLk())
                {
                  com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
                  if ((localf.oOt == 9) && (localf.oOv.equals(localObject2)))
                  {
                    com.tencent.mm.aw.a.bLi();
                    k.e(k.this).setImageResource(p.f.pardus_music_video_icon);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject2 = ((com.tencent.mm.plugin.sns.c.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.p.class)).Pm(((eax)paramAnonymousView.YYN.getFirst()).abgs.abgu);
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.aw.a.c(k.a(com.tencent.mm.kernel.h.baE().mCJ, (TimeLineObject)localObject2, ((eax)localObject1).abgr.abgw));
                k.e(k.this).setImageResource(p.f.pardus_music_pause_icon);
                localObject2 = com.tencent.mm.plugin.fts.ui.l.aEL(((eax)localObject1).abgr.hAP);
                com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), i, 1, k.b(k.this).syO, k.b(k.this).HxP.HyV, 27, "7$".concat(String.valueOf(localObject2)), ((eax)localObject1).abgr.abgw, "");
                k.b(k.this).HxP.HyV.Wq(27);
                k.a(k.this, paramAnonymousView.vhJ, ((eax)localObject1).abgr.abgw, (String)localObject2, "", "", 0, "");
                Log.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject2, ((eax)localObject1).abgr.abgw });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112341);
              }
            });
            this.HEq.setOnClickListener(this.HEJ);
            this.HEl.setOnClickListener(this.HEJ);
            label870:
            if (this.HEB) {
              this.Hxo = 2;
            }
            localObject1 = this.HDH.HxP.HyV;
            if (!this.HEB) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.d.b)localObject1).iX(i, j);
        if ((!this.HEA) && (!this.HEB)) {
          break label2751;
        }
        i = this.contentView.getMeasuredHeight();
        localObject1 = ValueAnimator.ofInt(new int[] { 0, i });
        ((ValueAnimator)localObject1).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(176930);
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            Log.i("MicroMsg.FTS.PardusSearchLogic", "native onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
            k.f(k.this).getLayoutParams().height = i;
            k.f(k.this).requestLayout();
            AppMethodBeat.o(176930);
          }
        });
        ((ValueAnimator)localObject1).addListener(new a(this.Hyw));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (qx)localte.YYH.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aEn(((qx)localObject1).YVQ.hAP);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aEn(((qx)localObject1).YVQ.IGG);
        localObject2 = ((qx)localObject1).YVQ.IHo;
        str1 = ((qx)localObject1).YVQ.abgx;
        this.HDH.HxP.HyV.a(k, System.currentTimeMillis(), "PardusMore", 1, ((qx)localObject1).YVQ.abgw);
        this.HDH.HxP.HyV.a(k + 1, System.currentTimeMillis(), ((qx)localObject1).YVQ.abgw, 1, ((qx)localObject1).YVQ.abgw);
        g(localte.vhJ, ((qx)localObject1).YVQ.abgw, com.tencent.mm.plugin.fts.ui.l.aEL(((qx)localObject1).YVQ.hAP), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (gfj)localte.YYI.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aEn(((gfj)localObject1).YVQ.hAP);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aEn(((gfj)localObject1).YVQ.IGG);
        localObject2 = ((gfj)localObject1).YVQ.IHo;
        str1 = ((gfj)localObject1).YVQ.abgx;
        this.HDH.HxP.HyV.a(k, System.currentTimeMillis(), "PardusMore", 2, ((gfj)localObject1).YVQ.abgw);
        this.HDH.HxP.HyV.a(k + 1, System.currentTimeMillis(), ((gfj)localObject1).YVQ.abgw, 2, ((gfj)localObject1).YVQ.abgw);
        g(localte.vhJ, ((gfj)localObject1).YVQ.abgw, com.tencent.mm.plugin.fts.ui.l.aEL(((gfj)localObject1).YVQ.hAP), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (akt)localte.YYJ.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.aEn(((akt)localObject5).YVQ.hAP);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aEn(((akt)localObject5).YVQ.IGG);
        localObject2 = ((akt)localObject5).YVQ.IHo;
        str1 = ((akt)localObject5).YVQ.abgx;
        localObject1 = ((akt)localObject5).ZrX;
        this.HDH.HxP.HyV.a(k, System.currentTimeMillis(), "PardusMore", 4, ((akt)localObject5).YVQ.abgw);
        this.HDH.HxP.HyV.a(k + 1, System.currentTimeMillis(), ((akt)localObject5).YVQ.abgw, 4, ((akt)localObject5).YVQ.abgw);
        g(localte.vhJ, ((akt)localObject5).YVQ.abgw, com.tencent.mm.plugin.fts.ui.l.aEL(((akt)localObject5).YVQ.hAP), "", "");
        localObject5 = "";
        break;
        eax localeax = (eax)localte.YYN.getFirst();
        localObject5 = localeax.abgr.abgw;
        localObject4 = com.tencent.mm.plugin.fts.a.f.aEn(localeax.abgr.hAP);
        localObject3 = com.tencent.mm.plugin.fts.a.f.aEn(localeax.abgr.IGG);
        localObject2 = localeax.abgr.IHo;
        str1 = localeax.abgr.abgx;
        j = localeax.abgr.crr;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localte.vhJ != 5) {
            break label1799;
          }
          j = 8;
        }
        for (;;)
        {
          this.HDH.HxP.HyV.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.HDH.HxP.HyV.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          g(localte.vhJ, (String)localObject5, com.tencent.mm.plugin.fts.ui.l.aEL(localeax.abgr.hAP), "", "");
          localObject1 = "";
          break;
          if (j < 3600L) {}
          for (localObject1 = "mm:ss";; localObject1 = "HH:mm:ss")
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            str2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(j * 1000L));
            break;
          }
          label1799:
          if (localte.vhJ == 4194304) {
            j = 6;
          } else if (localte.vhJ == 512) {
            j = 7;
          }
        }
        this.HDZ.setVisibility(0);
        this.HEb.setVisibility(0);
        this.HEb.setTag(localte);
        this.HEf.setVisibility(8);
        this.HEl.setVisibility(8);
        this.HEq.setVisibility(8);
        this.HEc.setText((CharSequence)localObject4);
        if (!Util.isNullOrNil((CharSequence)localObject3)) {
          if (this.HEd.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.HDS)
          {
            this.HEd.setMaxLines(2);
            label1936:
            this.HEd.setText((CharSequence)localObject3);
            this.HEd.setVisibility(0);
            label1953:
            localObject1 = this.HDH.getContext();
            localObject3 = this.lBC;
            j = p.c.brand_default_head;
            if (localte.vhJ == 5) {
              break label2043;
            }
          }
        }
        label2043:
        for (boolean bool = true;; bool = false)
        {
          o.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, j, bool);
          this.HEe.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.HEd.setMaxLines(1);
          break label1936;
          this.HEd.setVisibility(8);
          break label1953;
        }
        this.HDZ.setVisibility(0);
        this.HEb.setVisibility(8);
        this.HEf.setVisibility(0);
        this.HEl.setVisibility(8);
        this.HEq.setVisibility(8);
        this.HEf.setTag(localte);
        if (!Util.isNullOrNil((CharSequence)localObject4)) {
          if (!Util.isNullOrNil((String)localObject2))
          {
            this.HEh.setMaxLines(1);
            this.HEi.setMaxLines(2);
            this.HEg.setVisibility(0);
            localObject5 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKo = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKB = p.c.default_icon;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKI = 1.0F;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).nrc = true;
            localObject5 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).bKx();
            com.tencent.mm.modelimage.r.bKe().a((String)localObject2, this.HEg, (com.tencent.mm.modelimage.loader.a.c)localObject5);
            label2197:
            this.HEh.setText((CharSequence)localObject4);
            this.HEh.setVisibility(0);
            label2214:
            if (Util.isNullOrNil((CharSequence)localObject3)) {
              break label2356;
            }
            this.HEi.setText((CharSequence)localObject3);
            this.HEi.setVisibility(0);
          }
        }
        for (;;)
        {
          this.HEj.setText(str1);
          this.HEk.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.HEg.setVisibility(8);
          if (this.HEh.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.HDU)
          {
            this.HEh.setMaxLines(2);
            this.HEi.setMaxLines(1);
            break label2197;
          }
          this.HEh.setMaxLines(1);
          this.HEi.setMaxLines(2);
          break label2197;
          this.HEh.setVisibility(8);
          break label2214;
          label2356:
          this.HEi.setVisibility(8);
        }
        this.HDZ.setVisibility(0);
        this.HEb.setVisibility(8);
        this.HEf.setVisibility(8);
        this.HEq.setVisibility(8);
        this.HEl.setVisibility(0);
        this.HEl.setTag(localte);
        this.HEo.setText((CharSequence)localObject4);
        this.HEp.setText(str1);
        this.HEn.setText(str2);
        localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKo = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = p.c.default_video_icon;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKI = 1.0F;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
        localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx();
        com.tencent.mm.modelimage.r.bKe().a((String)localObject2, this.HEm, (com.tencent.mm.modelimage.loader.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label788;
        this.HDZ.setVisibility(0);
        this.HEb.setVisibility(8);
        this.HEf.setVisibility(8);
        this.HEl.setVisibility(8);
        this.HEq.setVisibility(0);
        this.HEq.setTag(localte);
        this.HEr.setTag(localte);
        this.HEt.setText((CharSequence)localObject4);
        this.HEu.setText((CharSequence)localObject3);
        this.HEv.setText(str1);
        if ((com.tencent.mm.aw.a.bLk()) && (com.tencent.mm.aw.a.bLn().oOv.equals(localObject5))) {
          this.HEr.setImageResource(p.f.pardus_music_pause_icon);
        }
        for (;;)
        {
          localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKo = true;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKB = p.c.default_music_icon;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).oKI = 1.0F;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).nrc = true;
          localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx();
          com.tencent.mm.modelimage.r.bKe().a((String)localObject2, this.HEs, (com.tencent.mm.modelimage.loader.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.HEM.alive();
          break;
          this.HEr.setImageResource(p.f.pardus_music_video_icon);
        }
        this.HDZ.setVisibility(8);
        this.contentView.measure(0, 0);
        break label870;
      }
      label2751:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.Hyu != null)
    {
      String str = this.Hyu.aayf;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.Hyw;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  private void iH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.HDH.HxP.HyQ = true;
    if ((paramString1 == null) || (Util.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.teM <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.teM = System.currentTimeMillis();
    long l = e.HrM;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(this.HDH.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  public final void P(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.Hyu != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.Hyu.aayf, paramString2, Long.valueOf(this.Hyw) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!Util.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    n(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void Wu(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.HED) && (!Util.isNullOrNil(this.query)))
    {
      as.u(this.query, this.Hxo, paramInt, 3);
      this.HED = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.HEy, paramb });
    this.HEy = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(eay parameay)
  {
    AppMethodBeat.i(176934);
    switch (parameay.YVh)
    {
    }
    for (;;)
    {
      Wu(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", parameay.IGI);
      com.tencent.mm.br.c.b(this.HDH, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject1);
      continue;
      localObject1 = new zp();
      ((zp)localObject1).icM.userName = parameay.UserName;
      ((zp)localObject1).icM.icO = parameay.ZrY;
      ((zp)localObject1).icM.appVersion = parameay.ZrZ;
      ((zp)localObject1).icM.hzx = parameay.Zsa;
      ((zp)localObject1).publish();
      continue;
      localObject1 = parameay.query;
      Object localObject2 = parameay.abgv;
      parameay = new HashMap();
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        Iterator localIterator = ((JSONObject)localObject2).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          parameay.put(str, ((JSONObject)localObject2).optString(str));
        }
      }
      catch (Exception localException)
      {
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(this.HDH, 3, (String)localObject1, String.valueOf(e.HrM), parameay);
      }
    }
  }
  
  public final void bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(265971);
    if ((paramBoolean) || (paramInt != 0))
    {
      this.Hyq.setVisibility(0);
      AppMethodBeat.o(265971);
      return;
    }
    this.Hyq.setVisibility(8);
    AppMethodBeat.o(265971);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.HEy = b.HER;
    this.Hxo = 1;
    this.Hyw = 0L;
    this.HxE = 0L;
    this.HEz = false;
    this.HEA = false;
    this.HEB = false;
    this.HED = false;
    this.query = null;
    this.Hyu = null;
    this.HEM.dead();
    if (this.HEw != null) {
      this.HEw.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final void dBz()
  {
    AppMethodBeat.i(112360);
    boolean bool = this.HEB;
    if (this.Hyu != null) {}
    for (Object localObject = this.Hyu.toJSON();; localObject = "null")
    {
      Log.i("MicroMsg.FTS.PardusSearchLogic", "updateFooterView %s %s", new Object[] { Boolean.valueOf(bool), localObject });
      if (!aj.aBu()) {
        break;
      }
      AppMethodBeat.o(112360);
      return;
    }
    if ((!this.HEB) && (!this.HEC))
    {
      this.Hyr.removeAllViews();
      if ((this.Hyu == null) || (this.Hyu.abgF == null)) {
        localObject = null;
      }
      while ((!this.HEA) && (localObject != null) && (((List)localObject).size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < ((List)localObject).size())
          {
            fkk localfkk = (fkk)((List)localObject).get(i);
            aqp localaqp = new aqp();
            localaqp.ZxJ = localfkk;
            localaqp.crs = i;
            View localView = this.HDH.getLayoutInflater().inflate(p.e.fts_websearch_relevant_item, this.Hyr, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                paramAnonymousView = (aqp)paramAnonymousView.getTag();
                if (paramAnonymousView.ZxJ.IHl == 3) {
                  if ((paramAnonymousView.ZxJ.abLn != null) && (!Util.isNullOrNil(paramAnonymousView.ZxJ.abLn.ZV()))) {
                    k.iI(paramAnonymousView.ZxJ.abLn.ZV(), k.c(k.this));
                  }
                }
                for (;;)
                {
                  localObject = k.b(k.this).HxP.HyV;
                  com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), k.b(k.this).HxP.getCount(), k.b(k.this).syO, (com.tencent.mm.plugin.fts.ui.d.b)localObject, 23);
                  k.b(k.this).HxP.HyQ = true;
                  if (!k.b(k.this).HxP.HyH)
                  {
                    k.b(k.this).HxP.HyH = true;
                    com.tencent.mm.plugin.fts.ui.l.a(paramAnonymousView.ZxJ.abiz, true, k.b(k.this).HxP.getCount(), 0, (com.tencent.mm.plugin.fts.ui.d.b)localObject);
                  }
                  k.this.Wu(7);
                  as.ate(3);
                  k.b(k.this).HxP.HyV.Wq(23);
                  k.a(k.this, 0, "", "", "", "", paramAnonymousView.crs + 1, paramAnonymousView.ZxJ.abgw);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112337);
                  return;
                  Log.e("MicroMsg.FTS.PardusSearchLogic", "updateFooterView, fts h5 relatedItem.Item.JumpType = " + paramAnonymousView.ZxJ.IHl + ", but JumpUrl = " + paramAnonymousView.ZxJ.abLn);
                  continue;
                  k.this.P(paramAnonymousView.ZxJ.abiz, 7, paramAnonymousView.ZxJ.abgw);
                }
              }
            });
            TextView localTextView = (TextView)localView.findViewById(p.d.content);
            localTextView.setText(localfkk.abiz);
            localTextView.setContentDescription(localfkk.abiz + localTextView.getContext().getResources().getString(p.g.fts_search_biz_btn));
            ((TextView)localView.findViewById(p.d.lebal)).setText(localfkk.ILD);
            localView.setTag(localaqp);
            this.Hyr.addView(localView);
            i += 1;
            continue;
            localObject = this.Hyu.abgF.YIB;
            break;
          }
        }
        this.HDH.HxP.HyV.iY(((List)localObject).size(), 1);
        this.Hyr.setVisibility(0);
        this.HDH.HxP.HyV.hW((List)localObject);
      }
      for (;;)
      {
        this.Hyo.setVisibility(0);
        this.Hyp.setVisibility(0);
        this.HDH.HxP.HyV.fyY();
        AppMethodBeat.o(112360);
        return;
        this.HDH.HxP.HyV.iY(0, 1);
        this.Hyr.setVisibility(8);
      }
    }
    this.HDH.HxP.HyV.iY(0, 0);
    this.Hyp.setVisibility(8);
    this.Hyo.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final View fbq()
  {
    AppMethodBeat.i(112361);
    if (this.Hyn == null)
    {
      this.Hyn = this.HDH.getLayoutInflater().inflate(p.e.fts_web_search_footer, null, false);
      this.Hyp = this.Hyn.findViewById(p.d.web_search_bar_layout);
      this.Hyo = this.Hyn.findViewById(p.d.web_search_layout);
      this.Hyq = this.Hyn.findViewById(p.d.web_search_divider);
      this.Hys = ((TextView)this.Hyn.findViewById(p.d.web_search_title_tv));
      this.HEK = ((TextView)this.Hyn.findViewById(p.d.web_search_title_suffix));
      this.Hyt = ((TextView)this.Hyn.findViewById(p.d.web_search_desc_tv));
      this.HEL = ((ImageView)this.Hyn.findViewById(p.d.websearch_icon_pardus));
      this.Hyr = ((LinearLayout)this.Hyo.findViewById(p.d.relevant_search_layout));
    }
    try
    {
      Object localObject2 = al.bix("webSearchBar");
      Object localObject1 = ((JSONObject)localObject2).optString("wording");
      Log.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s， webSearchObj = %s.", new Object[] { localObject1, localObject2 });
      this.Hyt.setText((CharSequence)localObject1);
      this.Hyt.setContentDescription((String)localObject1 + this.Hyt.getContext().getResources().getString(p.g.fts_search_biz_btn));
      localObject1 = ((JSONObject)localObject2).optString("icon");
      Log.i("MicroMsg.FTS.PardusSearchLogic", "set iconPath %s", new Object[] { localObject1 });
      String str = ((JSONObject)localObject2).optString("title_prefix");
      localObject2 = ((JSONObject)localObject2).optString("title_suffix");
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject2)))
      {
        localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKo = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKB = p.f.fts_websearch_icon;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKI = 1.0F;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).nrc = true;
        localObject2 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx();
        com.tencent.mm.modelimage.r.bKe().a((String)localObject1, this.HEL, (com.tencent.mm.modelimage.loader.a.c)localObject2);
      }
      label352:
      this.Hyp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(112333);
            return;
          }
          k.b(k.this).HxP.HyQ = true;
          if (!k.b(k.this).HxP.HyH)
          {
            k.b(k.this).HxP.HyH = true;
            com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), true, k.b(k.this).HxP.getCount(), 0, k.b(k.this).HxP.HyV);
          }
          k.this.fk(k.c(k.this), 15);
          k.b(k.this).HxP.HyQ = true;
          k.this.Wu(2);
          as.ate(3);
          k.b(k.this).HxP.HyV.Wq(18);
          com.tencent.mm.plugin.fts.ui.l.a(k.c(k.this), k.b(k.this).HxP.getCount(), k.b(k.this).syO, k.b(k.this).HxP.HyV, 18);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112333);
        }
      });
      localObject1 = this.Hyn;
      AppMethodBeat.o(112361);
      return localObject1;
    }
    catch (Exception localException)
    {
      break label352;
    }
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.Hyu != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.Hyu.aayf, paramString, Long.valueOf(this.Hyw) });
    }
    iH(paramString, str);
    AppMethodBeat.o(176935);
  }
  
  public final void fxG()
  {
    AppMethodBeat.i(112352);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "cancelSearch %s", new Object[] { Long.valueOf(this.Hyw) });
    this.HEE.removeMessages(1);
    if (this.HEx != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.HEx);
      com.tencent.mm.kernel.h.aZW().b(1076, this);
      this.HEx = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void fzB()
  {
    AppMethodBeat.i(112356);
    if (this.HEF != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.HEF);
      com.tencent.mm.kernel.h.aZW().b(1417, this);
      this.HEF = null;
    }
    AppMethodBeat.o(112356);
  }
  
  public final void fzC()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.HDH.vO(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.Hyr != null)
    {
      this.Hyr.removeAllViews();
      this.Hyr.setVisibility(8);
    }
    if (this.Hyo != null) {
      this.Hyo.setVisibility(8);
    }
    if (this.Hyp != null) {
      this.Hyp.setVisibility(8);
    }
    if (this.HEw != null) {
      this.HEw.fzE();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void g(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112365);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("pardussearch=expose&searchid=");
      localStringBuffer.append(getSearchId());
      localStringBuffer.append("&query=");
      localStringBuffer.append(com.tencent.mm.compatible.util.r.as(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(com.tencent.mm.compatible.util.r.as(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.r.as(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.r.as(paramString4, "utf8"));
      Log.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new eqy();
      paramString1.abuE = localStringBuffer.toString();
      paramString1 = new ae(paramString1);
      com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void n(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.HDH.HxP.HyQ = true;
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.teM <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.teM = System.currentTimeMillis();
    long l = e.HrM;
    paramMap.put("clickType", "7");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(this.HDH.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      fzA();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(112359);
    Log.i("MicroMsg.FTS.PardusSearchLogic", "onSceneEnd %s %s %s %s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    long l;
    boolean bool1;
    if (paramp.equals(this.HEF))
    {
      com.tencent.mm.kernel.h.aZW().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.HEH = this.HEF.WnY.abgq;
        Log.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.HEH) });
        AppMethodBeat.o(112359);
      }
    }
    else if (paramp.equals(this.HEx))
    {
      paramString = this.HEx.Woa;
      if (paramString.aaye.equals(String.valueOf(this.Hyw)))
      {
        l = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjE, 500);
        if (cn.bDw() - this.HxE > l) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      a(b.HET);
      com.tencent.mm.kernel.h.aZW().b(1076, this);
      boolean bool2;
      label272:
      label306:
      String str;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.fts.ui.l.ak(this.Hyw, 4);
        this.Hyu = this.HEx.WnZ;
        if ((this.Hyu != null) && (!Util.isNullOrNil(this.Hyu.abgG)) && (!bool1))
        {
          bool2 = true;
          this.HEC = bool2;
          if ((this.Hyu == null) || (this.Hyu.abgB.isEmpty()) || (bool1)) {
            break label460;
          }
          bool2 = true;
          this.HEB = bool2;
          Log.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %s hasNativeResult %s isTimeout:%s timeout:%s", new Object[] { Boolean.valueOf(this.HEC), Boolean.valueOf(this.HEB), Boolean.valueOf(bool1), Long.valueOf(l) });
          if (!this.HEz)
          {
            if (!this.HEC) {
              break label466;
            }
            paramString = this.HEw;
            str = this.Hyu.abgG;
            paramString.hTU = this.query;
            paramp = new JSONObject();
          }
        }
      }
      try
      {
        paramp.put("info", str);
        label417:
        paramString.HyW.HDH.runOnUiThread(new l.1(paramString, paramp));
        for (;;)
        {
          dBz();
          AppMethodBeat.o(112359);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label272;
          label460:
          bool2 = false;
          break label306;
          label466:
          if (this.HEB)
          {
            fzD();
            continue;
            com.tencent.mm.plugin.fts.ui.l.ak(this.Hyw, 5);
          }
        }
        Log.i("MicroMsg.FTS.PardusSearchLogic", "onSceneEnd invalid searchId return %s %s", new Object[] { paramString.aaye, Long.valueOf(this.Hyw) });
        AppMethodBeat.o(112359);
        return;
      }
      catch (Exception localException)
      {
        break label417;
      }
    }
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private long HEQ;
    
    public a(long paramLong)
    {
      this.HEQ = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.HEQ), Long.valueOf(k.a(k.this)) });
      if (this.HEQ == k.a(k.this))
      {
        k.b(k.this).vO(true);
        if (k.g(k.this) == k.b.HEU)
        {
          k.this.a(k.b.HEV);
          com.tencent.mm.plugin.fts.ui.l.ak(k.a(k.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.HEQ), Long.valueOf(k.a(k.this)) });
      if (this.HEQ == k.a(k.this))
      {
        k.b(k.this).vO(false);
        k.this.a(k.b.HEU);
        com.tencent.mm.plugin.fts.ui.l.ak(k.a(k.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      HER = new b("None", 0);
      HES = new b("StartSearch", 1);
      HET = new b("ReturnResult", 2);
      HEU = new b("StartAnimation", 3);
      HEV = new b("ShowResult", 4);
      HEW = new b[] { HER, HES, HET, HEU, HEV };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */
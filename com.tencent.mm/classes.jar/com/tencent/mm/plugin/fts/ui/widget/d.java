package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.j;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public final class d
  implements View.OnFocusChangeListener, com.tencent.mm.ak.g
{
  public boolean cZP;
  public View contentView;
  public ImageView fuY;
  public long lqi;
  public String query;
  public int sCc;
  public long sCr;
  public View sFq;
  public TextView sFr;
  public long sGa;
  public ao sGd;
  public View sHA;
  public ImageView sHB;
  public ImageView sHC;
  public TextView sHD;
  public TextView sHE;
  public TextView sHF;
  public e sHG;
  private cdg sHH;
  public com.tencent.mm.plugin.websearch.api.o sHI;
  public b sHJ;
  public boolean sHK;
  public boolean sHL;
  private boolean sHM;
  private boolean sHN;
  private com.tencent.mm.plugin.websearch.api.n sHO;
  private long sHP;
  private long sHQ;
  private View.OnClickListener sHR;
  private View.OnClickListener sHS;
  private View sHT;
  private View sHU;
  public View sHV;
  private View sHW;
  public LinearLayout sHX;
  public TextView sHY;
  private TextView sHZ;
  public FTSMainUI sHc;
  public View sHd;
  private int sHe;
  private int sHf;
  private int sHg;
  public View sHh;
  public TextView sHi;
  public TextView sHj;
  public TextView sHk;
  public View sHl;
  public View sHm;
  public TextView sHn;
  public TextView sHo;
  public View sHp;
  public ImageView sHq;
  public TextView sHr;
  public TextView sHs;
  public TextView sHt;
  public TextView sHu;
  public View sHv;
  public ImageView sHw;
  public TextView sHx;
  public TextView sHy;
  public TextView sHz;
  private com.tencent.mm.sdk.b.c<lw> sIa;
  private long szB;
  
  public d(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.sHe = 0;
    this.sHf = 0;
    this.sHg = 0;
    this.sHJ = b.sId;
    this.sHK = false;
    this.sHL = false;
    this.cZP = false;
    this.sHM = false;
    this.sHN = false;
    this.sCc = 1;
    this.sGd = new ao(Looper.getMainLooper())
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
          if (paramAnonymousMessage.obj.equals(Long.valueOf(d.a(d.this))))
          {
            d.this.a(d.b.sIi);
            d.a(d.this, System.currentTimeMillis());
            ac.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(d.b(d.this) - d.c(d.this)) });
            k.K(d.a(d.this), 5);
            d.this.cKD();
            d.this.cdr();
          }
        }
      }
    };
    this.sHQ = 60L;
    this.sHR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        paramAnonymousView = (agh)paramAnonymousView.getTag();
        d.this.z(paramAnonymousView.Eyo.FtK, 22, paramAnonymousView.Eyo.FrN);
        d.d(d.this).sDq.sCS = true;
        k.a(d.e(d.this), 1, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 28, "", "", "");
        d.d(d.this).sDq.sCX.FJ(28);
        d.a(d.this, 0, "", "", "", paramAnonymousView.Eyo.FrN, paramAnonymousView.DWO + 1, "");
        d.this.FN(6);
        AppMethodBeat.o(112336);
      }
    };
    this.sHS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        paramAnonymousView = (ps)paramAnonymousView.getTag();
        switch (paramAnonymousView.ndI)
        {
        default: 
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!d.f(d.this)) {
          j = 1;
        }
        cdc localcdc = (cdc)paramAnonymousView.Egq.getFirst();
        Object localObject = localcdc.FrK;
        d.this.a((cdd)localObject);
        int i;
        if (paramAnonymousView.ndI == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject = k.agq(localcdc.FrJ.Title);
          k.a(d.e(d.this), j, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, i + "$" + (String)localObject, localcdc.FrJ.FrN, "");
          d.d(d.this).sDq.sCX.FJ(27);
          d.a(d.this, paramAnonymousView.ndI, localcdc.FrJ.FrN, (String)localObject, "", "", 0, "");
          ac.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject, localcdc.FrJ.FrN });
          break;
          if (paramAnonymousView.ndI == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.sIa = new d.4(this);
    this.sHc = paramFTSMainUI;
    this.sHe = (com.tencent.mm.cc.a.ig(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.sHf = (com.tencent.mm.cc.a.ig(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.sHg = (com.tencent.mm.cc.a.ig(paramFTSMainUI.getContext()) - com.tencent.mm.cc.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    cLU();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.ay.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.FQo == null) || (paramTimeLineObject.FQo.Etz == null) || (paramTimeLineObject.FQo.Etz.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    btz localbtz = (btz)paramTimeLineObject.FQo.Etz.get(0);
    if (localbtz == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
    localf.hNQ = 9;
    localf.hNS = paramString2;
    localf.hNT = 0.0F;
    localf.hNW = "";
    if (!TextUtils.isEmpty(localbtz.songAlbumUrl)) {
      localf.hOj = localbtz.songAlbumUrl;
    }
    localf.hNX = localbtz.Fjh;
    localf.hOc = null;
    localf.hNR = 1;
    localf.hOb = localbtz.songLyric;
    localf.hNU = localbtz.Title;
    localf.hNV = localbtz.Desc;
    paramString2 = localObject;
    if (paramTimeLineObject.FQo != null) {
      paramString2 = paramTimeLineObject.FQo.Url;
    }
    localf.hOa = paramString2;
    localf.hNZ = localbtz.Fjl;
    localf.hNY = localbtz.Url;
    localf.hOg = localbtz.Fji;
    localf.hOi = localbtz.Id;
    localf.hOd = paramString1;
    localf.hOf = paramTimeLineObject.FQn.Id;
    localf.hOm = paramTimeLineObject.ncR;
    localf.hOt = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void cLU()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.sHP > this.sHQ * 1000L)
    {
      ac.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      cLV();
      this.sHO = new com.tencent.mm.plugin.websearch.api.n(new cda());
      com.tencent.mm.kernel.g.agi().a(1417, this);
      com.tencent.mm.kernel.g.agi().a(this.sHO, 0);
      this.sHP = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void cLX()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.sHH == null) || (this.sHH.FrS == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.sHL = true;
      this.sHh.setVisibility(0);
      j = ((dfn)((List)localObject1).get(0)).FtK.length() + 0;
      localObject2 = new agh();
      ((agh)localObject2).Eyo = ((dfn)((List)localObject1).get(0));
      ((agh)localObject2).DWO = 0;
      this.sHi.setTag(localObject2);
      this.sHi.setText(((dfn)((List)localObject1).get(0)).FtK);
      this.sHi.setOnClickListener(this.sHR);
      this.sHi.setVisibility(0);
      this.sHc.sDq.sCX.o(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((dfn)((List)localObject1).get(1)).FtK.length();
      this.sHj.setOnClickListener(this.sHR);
      localObject2 = new agh();
      ((agh)localObject2).Eyo = ((dfn)((List)localObject1).get(1));
      ((agh)localObject2).DWO = 1;
      this.sHj.setTag(localObject2);
      this.sHj.setText(((dfn)((List)localObject1).get(1)).FtK);
      this.sHj.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((dfn)((List)localObject1).get(2)).FtK.length() + j > 24) {
        break label499;
      }
      this.sHk.setOnClickListener(this.sHR);
      localObject2 = new agh();
      ((agh)localObject2).Eyo = ((dfn)((List)localObject1).get(2));
      ((agh)localObject2).DWO = 2;
      this.sHk.setTag(localObject2);
      this.sHk.setText(((dfn)((List)localObject1).get(2)).FtK);
      this.sHk.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.sHL)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((dfn)((List)localObject1).get(j)).FrN + "_";
            j += 1;
            continue;
            localObject1 = this.sHH.FrS.DSZ;
            break;
            label485:
            this.sHj.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.sHk.setVisibility(8);
            break label405;
            label511:
            this.sHk.setVisibility(8);
            break label405;
            this.sHh.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        e(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.sHL) {
      k = 1;
    }
    if (this.sHH.FrT.size() > 0) {}
    for (ps localps = (ps)this.sHH.FrT.getFirst();; localps = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localps != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.sHm.setTag(localps);
        switch (localps.ndI)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localps.ndI)
          {
          default: 
            this.cZP = false;
            this.sHl.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.sHm.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                d.this.dp(d.e(d.this), 21);
                ps localps = (ps)paramAnonymousView.getTag();
                paramAnonymousView = "";
                Object localObject = "";
                String str1;
                String str2;
                switch (localps.ndI)
                {
                default: 
                  str1 = "";
                  str2 = "";
                  if (d.f(d.this)) {
                    break;
                  }
                }
                for (int i = 1;; i = 2)
                {
                  k.a(d.e(d.this), i, 2, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, paramAnonymousView, (String)localObject, "");
                  d.d(d.this).sDq.sCX.FJ(27);
                  d.d(d.this).sDq.sCS = true;
                  d.a(d.this, localps.ndI, "more", str2, str1, "", 0, "");
                  d.this.FN(5);
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (no)localps.Egk.getFirst();
                  str2 = k.agq(((no)localObject).EdD.Title);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((no)localObject).EdD.FrN;
                  str1 = "";
                  break;
                  localObject = (dwf)localps.Egl.getFirst();
                  str2 = k.agq(((dwf)localObject).EdD.Title);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((dwf)localObject).EdD.FrN;
                  str1 = "";
                  break;
                  localObject = (acy)localps.Egm.getFirst();
                  str1 = ((acy)localObject).thh;
                  str2 = k.agq(((acy)localObject).EdD.Title);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((acy)localObject).EdD.FrN;
                  break;
                  localObject = (cdc)localps.Egq.getFirst();
                  str2 = k.agq(((cdc)localObject).FrJ.Title);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((cdc)localObject).FrJ.FrN;
                  str1 = "";
                  break;
                  localObject = (cdc)localps.Egq.getFirst();
                  str2 = k.agq(((cdc)localObject).FrJ.Title);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((cdc)localObject).FrJ.FrN;
                  str1 = "";
                  break;
                  localObject = (cdc)localps.Egq.getFirst();
                  str2 = k.agq(((cdc)localObject).FrJ.Title);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((cdc)localObject).FrJ.FrN;
                  str1 = "";
                  break;
                }
              }
            });
            this.sFq.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                int i = 2;
                AppMethodBeat.i(112339);
                if (!d.f(d.this)) {
                  i = 1;
                }
                try
                {
                  paramAnonymousView = (ps)paramAnonymousView.getTag();
                  if (paramAnonymousView.ndI == 64)
                  {
                    localObject1 = (dwf)paramAnonymousView.Egl.getFirst();
                    localObject2 = new ut();
                    ((ut)localObject2).dxt.userName = ((dwf)localObject1).ncR;
                    ((ut)localObject2).dxt.scene = 1027;
                    ((ut)localObject2).dxt.cYP = "2";
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
                    localObject2 = k.agq(((dwf)localObject1).EdD.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, "2$".concat(String.valueOf(localObject2)), ((dwf)localObject1).EdD.FrN, ((dwf)localObject1).ncR);
                    d.d(d.this).sDq.sCX.FJ(27);
                    d.a(d.this, paramAnonymousView.ndI, ((dwf)localObject1).EdD.FrN, (String)localObject2, "", "", 0, "");
                    ac.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((dwf)localObject1).ncR, ((dwf)localObject1).EdD.FrN });
                    d.this.FN(4);
                    AppMethodBeat.o(112339);
                    return;
                  }
                  if (paramAnonymousView.ndI == 1)
                  {
                    localObject1 = (no)paramAnonymousView.Egk.getFirst();
                    localObject2 = new JSONObject(((no)localObject1).EdE);
                    localObject3 = new Intent();
                    ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                    ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                    ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                    ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                    ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                    ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                    ((Intent)localObject3).putExtra("Contact_Scene", 3);
                    localObject4 = new aaf();
                    ((aaf)localObject4).iKh = ((JSONObject)localObject2).optInt("brandFlag", 0);
                    ((aaf)localObject4).iKk = ((JSONObject)localObject2).optString("iconUrl", "");
                    ((aaf)localObject4).iKj = ((JSONObject)localObject2).optString("brandInfo", "");
                    ((aaf)localObject4).iKi = ((JSONObject)localObject2).optString("externalInfo", "");
                  }
                }
                catch (Exception paramAnonymousView)
                {
                  try
                  {
                    label483:
                    do
                    {
                      for (;;)
                      {
                        ((Intent)localObject3).putExtra("Contact_customInfo", ((aaf)localObject4).toByteArray());
                        Object localObject4 = new Bundle();
                        ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(d.a(d.this)));
                        ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", d.e(d.this));
                        ((Bundle)localObject4).putInt("Contact_Scene", 3);
                        ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                        ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                        ((Intent)localObject3).putExtra("preChatTYPE", 10);
                        ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                        Object localObject3 = k.agq(((no)localObject1).EdD.Title);
                        k.a(d.e(d.this), i, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, "1$".concat(String.valueOf(localObject3)), ((no)localObject1).EdD.FrN, "");
                        d.this.FN(4);
                        d.d(d.this).sDq.sCX.FJ(27);
                        d.d(d.this).sDq.sCS = true;
                        d.a(d.this, paramAnonymousView.ndI, ((no)localObject1).EdD.FrN, (String)localObject3, "", "", 0, "");
                        ac.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((no)localObject1).EdD.FrN });
                        continue;
                        paramAnonymousView = paramAnonymousView;
                        ac.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                      }
                    } while (paramAnonymousView.ndI != 5);
                    Object localObject1 = (cdc)paramAnonymousView.Egq.getFirst();
                    Object localObject2 = ((cdc)localObject1).FrK;
                    d.this.a((cdd)localObject2);
                    localObject2 = k.agq(((cdc)localObject1).FrJ.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, "8$".concat(String.valueOf(localObject2)), ((cdc)localObject1).FrJ.FrN, "");
                    d.d(d.this).sDq.sCX.FJ(27);
                    d.a(d.this, paramAnonymousView.ndI, ((cdc)localObject1).FrJ.FrN, (String)localObject2, "", "", 0, "");
                    ac.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((cdc)localObject1).FrJ.FrN });
                  }
                  catch (IOException localIOException)
                  {
                    break label483;
                  }
                }
              }
            });
            this.sHp.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (ps)paramAnonymousView.getTag();
                    localacy = (acy)paramAnonymousView.Egm.getFirst();
                    if (localacy.tiE != 1) {
                      continue;
                    }
                    localObject = new ut();
                    ((ut)localObject).dxt.userName = localacy.ncR;
                    ((ut)localObject).dxt.dxv = localacy.EvI;
                    ((ut)localObject).dxt.aBM = localacy.EvJ;
                    ((ut)localObject).dxt.scene = 1027;
                    ((ut)localObject).dxt.cYP = (localacy.EvK + ":2");
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = k.agq(localacy.EdD.Title);
                    k.a(d.e(d.this), i, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, "4$".concat(String.valueOf(localObject)), localacy.EdD.FrN, "");
                    d.this.FN(4);
                    d.d(d.this).sDq.sCX.FJ(27);
                    d.d(d.this).sDq.sCS = true;
                    d.a(d.this, paramAnonymousView.ndI, localacy.EdD.FrN, (String)localObject, localacy.thh, "", 0, "");
                    ac.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { localacy.EdD.FrN });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    acy localacy;
                    Object localObject;
                    ac.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  d.this.FN(4);
                  AppMethodBeat.o(112340);
                  return;
                  if (localacy.tiE == 0)
                  {
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("rawUrl", localacy.thh);
                    com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
                  }
                }
              }
            });
            this.sHB.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                paramAnonymousView = (ps)paramAnonymousView.getTag();
                cdc localcdc = (cdc)paramAnonymousView.Egq.getFirst();
                Object localObject = localcdc.FrJ.FrN;
                if (com.tencent.mm.ay.a.aGv())
                {
                  com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aGy();
                  if ((localf.hNQ == 9) && (localf.hNS.equals(localObject)))
                  {
                    com.tencent.mm.ay.a.aGt();
                    d.g(d.this).setImageResource(2131691022);
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject = ((com.tencent.mm.plugin.sns.b.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.n.class)).Ds(((cdc)paramAnonymousView.Egq.getFirst()).FrK.FrM);
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.ay.a.c(d.a(com.tencent.mm.kernel.g.agR().ghC, (TimeLineObject)localObject, localcdc.FrJ.FrN));
                d.g(d.this).setImageResource(2131691021);
                localObject = k.agq(localcdc.FrJ.Title);
                k.a(d.e(d.this), i, 1, d.d(d.this).kNw, d.d(d.this).sDq.sCX, 27, "7$".concat(String.valueOf(localObject)), localcdc.FrJ.FrN, "");
                d.d(d.this).sDq.sCX.FJ(27);
                d.a(d.this, paramAnonymousView.ndI, localcdc.FrJ.FrN, (String)localObject, "", "", 0, "");
                ac.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject, localcdc.FrJ.FrN });
                AppMethodBeat.o(112341);
              }
            });
            this.sHA.setOnClickListener(this.sHS);
            this.sHv.setOnClickListener(this.sHS);
            label867:
            if (this.cZP) {
              this.sCc = 2;
            }
            localObject1 = this.sHc.sDq.sCX;
            if (!this.cZP) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).fQ(i, j);
        if ((!this.sHL) && (!this.cZP)) {
          break label2753;
        }
        i = this.contentView.getMeasuredHeight();
        localObject1 = ValueAnimator.ofInt(new int[] { 0, i });
        ((ValueAnimator)localObject1).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(176930);
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            ac.i("MicroMsg.FTS.PardusSearchLogic", "native onAnimationUpdate %d", new Object[] { Integer.valueOf(i) });
            d.h(d.this).getLayoutParams().height = i;
            d.h(d.this).requestLayout();
            AppMethodBeat.o(176930);
          }
        });
        ((ValueAnimator)localObject1).addListener(new a(this.sGa));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        ac.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (no)localps.Egk.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.afV(((no)localObject1).EdD.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.afV(((no)localObject1).EdD.Desc);
        localObject2 = ((no)localObject1).EdD.IconUrl;
        str1 = ((no)localObject1).EdD.FrO;
        this.sHc.sDq.sCX.a(k, System.currentTimeMillis(), "PardusMore", 1, ((no)localObject1).EdD.FrN);
        this.sHc.sDq.sCX.a(k + 1, System.currentTimeMillis(), ((no)localObject1).EdD.FrN, 1, ((no)localObject1).EdD.FrN);
        e(localps.ndI, ((no)localObject1).EdD.FrN, k.agq(((no)localObject1).EdD.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (dwf)localps.Egl.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.afV(((dwf)localObject1).EdD.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.afV(((dwf)localObject1).EdD.Desc);
        localObject2 = ((dwf)localObject1).EdD.IconUrl;
        str1 = ((dwf)localObject1).EdD.FrO;
        this.sHc.sDq.sCX.a(k, System.currentTimeMillis(), "PardusMore", 2, ((dwf)localObject1).EdD.FrN);
        this.sHc.sDq.sCX.a(k + 1, System.currentTimeMillis(), ((dwf)localObject1).EdD.FrN, 2, ((dwf)localObject1).EdD.FrN);
        e(localps.ndI, ((dwf)localObject1).EdD.FrN, k.agq(((dwf)localObject1).EdD.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (acy)localps.Egm.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.afV(((acy)localObject5).EdD.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.afV(((acy)localObject5).EdD.Desc);
        localObject2 = ((acy)localObject5).EdD.IconUrl;
        str1 = ((acy)localObject5).EdD.FrO;
        localObject1 = ((acy)localObject5).EvH;
        this.sHc.sDq.sCX.a(k, System.currentTimeMillis(), "PardusMore", 4, ((acy)localObject5).EdD.FrN);
        this.sHc.sDq.sCX.a(k + 1, System.currentTimeMillis(), ((acy)localObject5).EdD.FrN, 4, ((acy)localObject5).EdD.FrN);
        e(localps.ndI, ((acy)localObject5).EdD.FrN, k.agq(((acy)localObject5).EdD.Title), "", "");
        localObject5 = "";
        break;
        cdc localcdc = (cdc)localps.Egq.getFirst();
        localObject5 = localcdc.FrJ.FrN;
        localObject4 = com.tencent.mm.plugin.fts.a.f.afV(localcdc.FrJ.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.afV(localcdc.FrJ.Desc);
        localObject2 = localcdc.FrJ.IconUrl;
        str1 = localcdc.FrJ.FrO;
        j = localcdc.FrJ.sVO;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localps.ndI != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.sHc.sDq.sCX.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.sHc.sDq.sCX.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          e(localps.ndI, (String)localObject5, k.agq(localcdc.FrJ.Title), "", "");
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
          label1782:
          if (localps.ndI == 4194304) {
            j = 6;
          } else if (localps.ndI == 512) {
            j = 7;
          }
        }
        this.cZP = true;
        this.sHl.setVisibility(0);
        this.sFq.setVisibility(0);
        this.sFq.setTag(localps);
        this.sHp.setVisibility(8);
        this.sHv.setVisibility(8);
        this.sHA.setVisibility(8);
        this.sHn.setText((CharSequence)localObject4);
        if (!bs.aj((CharSequence)localObject3)) {
          if (this.sFr.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.sHe)
          {
            this.sFr.setMaxLines(2);
            label1924:
            this.sFr.setText((CharSequence)localObject3);
            this.sFr.setVisibility(0);
            label1941:
            localObject1 = this.sHc.getContext();
            localObject3 = this.fuY;
            if (localps.ndI == 5) {
              break label2029;
            }
          }
        }
        label2029:
        for (boolean bool = true;; bool = false)
        {
          m.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, 2131231342, bool);
          this.sHo.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.sFr.setMaxLines(1);
          break label1924;
          this.sFr.setVisibility(8);
          break label1941;
        }
        this.cZP = true;
        this.sHl.setVisibility(0);
        this.sFq.setVisibility(8);
        this.sHp.setVisibility(0);
        this.sHv.setVisibility(8);
        this.sHA.setVisibility(8);
        this.sHp.setTag(localps);
        if (!bs.aj((CharSequence)localObject4)) {
          if (!bs.isNullOrNil((String)localObject2))
          {
            this.sHr.setMaxLines(1);
            this.sHs.setMaxLines(2);
            this.sHq.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).hKw = true;
            ((c.a)localObject5).hKI = 2131231879;
            ((c.a)localObject5).hKP = 1.0F;
            ((c.a)localObject5).gLt = true;
            localObject5 = ((c.a)localObject5).aFT();
            com.tencent.mm.av.o.aFB().a((String)localObject2, this.sHq, (com.tencent.mm.av.a.a.c)localObject5);
            label2188:
            this.sHr.setText((CharSequence)localObject4);
            this.sHr.setVisibility(0);
            label2205:
            if (bs.aj((CharSequence)localObject3)) {
              break label2347;
            }
            this.sHs.setText((CharSequence)localObject3);
            this.sHs.setVisibility(0);
          }
        }
        for (;;)
        {
          this.sHt.setText(str1);
          this.sHu.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.sHq.setVisibility(8);
          if (this.sHr.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.sHg)
          {
            this.sHr.setMaxLines(2);
            this.sHs.setMaxLines(1);
            break label2188;
          }
          this.sHr.setMaxLines(1);
          this.sHs.setMaxLines(2);
          break label2188;
          this.sHr.setVisibility(8);
          break label2205;
          label2347:
          this.sHs.setVisibility(8);
        }
        this.cZP = true;
        this.sHl.setVisibility(0);
        this.sFq.setVisibility(8);
        this.sHp.setVisibility(8);
        this.sHA.setVisibility(8);
        this.sHv.setVisibility(0);
        this.sHv.setTag(localps);
        this.sHy.setText((CharSequence)localObject4);
        this.sHz.setText(str1);
        this.sHx.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).hKw = true;
        ((c.a)localObject1).hKI = 2131231884;
        ((c.a)localObject1).hKP = 1.0F;
        ((c.a)localObject1).gLt = true;
        localObject1 = ((c.a)localObject1).aFT();
        com.tencent.mm.av.o.aFB().a((String)localObject2, this.sHw, (com.tencent.mm.av.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.cZP = true;
        this.sHl.setVisibility(0);
        this.sFq.setVisibility(8);
        this.sHp.setVisibility(8);
        this.sHv.setVisibility(8);
        this.sHA.setVisibility(0);
        this.sHA.setTag(localps);
        this.sHB.setTag(localps);
        this.sHD.setText((CharSequence)localObject4);
        this.sHE.setText((CharSequence)localObject3);
        this.sHF.setText(str1);
        if ((com.tencent.mm.ay.a.aGv()) && (com.tencent.mm.ay.a.aGy().hNS.equals(localObject5))) {
          this.sHB.setImageResource(2131691021);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).hKw = true;
          ((c.a)localObject1).hKI = 2131231882;
          ((c.a)localObject1).hKP = 1.0F;
          ((c.a)localObject1).gLt = true;
          localObject1 = ((c.a)localObject1).aFT();
          com.tencent.mm.av.o.aFB().a((String)localObject2, this.sHC, (com.tencent.mm.av.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.sIa.alive();
          break;
          this.sHB.setImageResource(2131691022);
        }
        this.sHl.setVisibility(8);
        this.contentView.measure(0, 0);
        break label867;
      }
      label2753:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.sHc.sDq.sCS = true;
    if ((paramString1 == null) || (bs.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.lqi <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.lqi = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.swV;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.sHc.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.sHH != null)
    {
      String str = this.sHH.FhW;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.sGa;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  public final void FN(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.sHN) && (!bs.isNullOrNil(this.query)))
    {
      com.tencent.mm.plugin.websearch.api.ai.p(this.query, this.sCc, paramInt, 3);
      this.sHN = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    ac.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.sHJ, paramb });
    this.sHJ = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(cdd paramcdd)
  {
    AppMethodBeat.i(176934);
    switch (paramcdd.Edq)
    {
    }
    for (;;)
    {
      FN(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramcdd.thh);
      com.tencent.mm.br.d.b(this.sHc, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      continue;
      localObject = new ut();
      ((ut)localObject).dxt.userName = paramcdd.ncR;
      ((ut)localObject).dxt.dxv = paramcdd.EvI;
      ((ut)localObject).dxt.aBM = paramcdd.EvJ;
      ((ut)localObject).dxt.cYP = paramcdd.EvK;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final View cBS()
  {
    AppMethodBeat.i(112361);
    if (this.sHT == null)
    {
      this.sHT = this.sHc.getLayoutInflater().inflate(2131494224, null, false);
      this.sHV = this.sHT.findViewById(2131306903);
      this.sHU = this.sHT.findViewById(2131306906);
      this.sHW = this.sHT.findViewById(2131306905);
      this.sHY = ((TextView)this.sHT.findViewById(2131306907));
      this.sHZ = ((TextView)this.sHT.findViewById(2131306904));
      this.sHX = ((LinearLayout)this.sHU.findViewById(2131303971));
    }
    try
    {
      Object localObject = ab.aAv("webSearchBar").optString("wording");
      ac.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.sHZ.setText((CharSequence)localObject);
      label163:
      this.sHV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          d.d(d.this).sDq.sCS = true;
          if (!d.d(d.this).sDq.sCJ)
          {
            d.d(d.this).sDq.sCJ = true;
            k.a(d.e(d.this), true, d.d(d.this).sDq.getCount(), 0, d.d(d.this).sDq.sCX);
          }
          d.this.dp(d.e(d.this), 15);
          d.d(d.this).sDq.sCS = true;
          d.this.FN(2);
          com.tencent.mm.plugin.websearch.api.ai.Us(3);
          d.d(d.this).sDq.sCX.FJ(18);
          k.a(d.e(d.this), d.d(d.this).sDq.getCount(), d.d(d.this).kNw, d.d(d.this).sDq.sCX, 18);
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.sHT;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void cKD()
  {
    AppMethodBeat.i(112352);
    this.sGd.removeMessages(1);
    if (this.sHI != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.sHI);
      com.tencent.mm.kernel.g.agi().b(1076, this);
      this.sHI = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void cLV()
  {
    AppMethodBeat.i(112356);
    if (this.sHO != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.sHO);
      com.tencent.mm.kernel.g.agi().b(1417, this);
      this.sHO = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void cLW()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.sHc.ms(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.sHX != null)
    {
      this.sHX.removeAllViews();
      this.sHX.setVisibility(8);
    }
    if (this.sHU != null) {
      this.sHU.setVisibility(8);
    }
    if (this.sHV != null) {
      this.sHV.setVisibility(8);
    }
    if (this.sHG != null) {
      this.sHG.cLY();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void cdr()
  {
    AppMethodBeat.i(112360);
    if (!this.cZP)
    {
      this.sHX.removeAllViews();
      LinkedList localLinkedList;
      if ((this.sHH == null) || (this.sHH.FrX == null)) {
        localLinkedList = null;
      }
      while ((!this.sHL) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            dfn localdfn = (dfn)localLinkedList.get(i);
            agh localagh = new agh();
            localagh.Eyo = localdfn;
            localagh.DWO = i;
            View localView = this.sHc.getLayoutInflater().inflate(2131494228, this.sHX, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                paramAnonymousView = (agh)paramAnonymousView.getTag();
                d.this.z(paramAnonymousView.Eyo.FtK, 7, paramAnonymousView.Eyo.FrN);
                com.tencent.mm.plugin.fts.ui.c.b localb = d.d(d.this).sDq.sCX;
                k.a(d.e(d.this), d.d(d.this).sDq.getCount(), d.d(d.this).kNw, localb, 23);
                d.d(d.this).sDq.sCS = true;
                if (!d.d(d.this).sDq.sCJ)
                {
                  d.d(d.this).sDq.sCJ = true;
                  k.a(paramAnonymousView.Eyo.FtK, true, d.d(d.this).sDq.getCount(), 0, localb);
                }
                d.this.FN(7);
                com.tencent.mm.plugin.websearch.api.ai.Us(3);
                d.d(d.this).sDq.sCX.FJ(23);
                d.a(d.this, 0, "", "", "", "", paramAnonymousView.DWO + 1, paramAnonymousView.Eyo.FrN);
                AppMethodBeat.o(112337);
              }
            });
            ((TextView)localView.findViewById(2131298739)).setText(localdfn.FtK);
            localView.setTag(localagh);
            this.sHX.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.sHH.FrX.DSZ;
            break;
          }
        }
        this.sHc.sDq.sCX.fR(localLinkedList.size(), 1);
        this.sHX.setVisibility(0);
        this.sHc.sDq.sCX.dM(localLinkedList);
      }
      for (;;)
      {
        this.sHU.setVisibility(0);
        this.sHV.setVisibility(0);
        this.sHc.sDq.sCX.cLs();
        AppMethodBeat.o(112360);
        return;
        this.sHc.sDq.sCX.fR(0, 1);
        this.sHX.setVisibility(8);
      }
    }
    this.sHc.sDq.sCX.fR(0, 0);
    this.sHV.setVisibility(8);
    this.sHU.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.sHJ = b.sId;
    this.sCc = 1;
    this.sGa = 0L;
    this.sCr = 0L;
    this.szB = 0L;
    this.sHK = false;
    this.sHL = false;
    this.cZP = false;
    this.sHN = false;
    this.query = null;
    this.sHH = null;
    this.sIa.dead();
    if (this.sHG != null) {
      this.sHG.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.sHW.setVisibility(0);
    }
    for (;;)
    {
      if ((paramBoolean1) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYo, com.tencent.mm.util.c.fwV()) == 0)) {
        cdr();
      }
      AppMethodBeat.o(112362);
      return;
      this.sHW.setVisibility(8);
    }
  }
  
  public final void dp(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.sHH != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.sHH.FhW, paramString, Long.valueOf(this.sGa) });
    }
    gC(paramString, str);
    AppMethodBeat.o(176935);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112365);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("pardussearch=expose&searchid=");
      localStringBuffer.append(getSearchId());
      localStringBuffer.append("&query=");
      localStringBuffer.append(p.encode(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(p.encode(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(p.encode(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(p.encode(paramString4, "utf8"));
      ac.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cpk();
      paramString1.FCf = localStringBuffer.toString();
      paramString1 = new v(paramString1);
      com.tencent.mm.kernel.g.agi().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void k(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.sHc.sDq.sCS = true;
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.lqi <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.lqi = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.swV;
    paramMap.put("clickType", "7");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(this.sHc.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    ac.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      cLU();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(112359);
    boolean bool;
    label230:
    Object localObject;
    if (paramn.equals(this.sHO))
    {
      com.tencent.mm.kernel.g.agi().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sHQ = this.sHO.BYd.FrI;
        ac.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.sHQ) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramn.equals(this.sHI)) && (this.sHI.BYf.FrP.equals(String.valueOf(this.sGa))))
    {
      a(b.sIf);
      this.sGd.removeMessages(1);
      com.tencent.mm.kernel.g.agi().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label412;
      }
      k.K(this.sGa, 4);
      this.sHH = this.sHI.BYe;
      if ((this.sHH == null) || (bs.isNullOrNil(this.sHH.FrY))) {
        break label333;
      }
      bool = true;
      this.sHM = bool;
      bool = this.sHM;
      paramInt2 = this.sHH.FrT.size();
      if (this.sHH.FrS != null) {
        break label339;
      }
      paramInt1 = i;
      ac.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (!this.sHK)
      {
        if (!this.sHM) {
          break label405;
        }
        paramString = this.sHG;
        paramn = this.sHH.FrY;
        localObject = this.query;
        if (paramString.sIm) {
          break label356;
        }
        ac.i("MicroMsg.FTS.PardusWebViewLogic", "webview not ready");
      }
    }
    for (;;)
    {
      if (!this.sHM) {
        cdr();
      }
      AppMethodBeat.o(112359);
      return;
      label333:
      bool = false;
      break;
      label339:
      paramInt1 = this.sHH.FrS.DSZ.size();
      break label230;
      label356:
      paramString.dpS = ((String)localObject);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("info", paramn);
        label382:
        paramString.sCY.sHc.runOnUiThread(new e.1(paramString, (JSONObject)localObject));
        continue;
        label405:
        cLX();
        continue;
        label412:
        k.K(this.sGa, 5);
      }
      catch (Exception paramn)
      {
        break label382;
      }
    }
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.sHH != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.sHH.FhW, paramString2, Long.valueOf(this.sGa) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!bs.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    k(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private long sIc;
    
    public a(long paramLong)
    {
      this.sIc = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      ac.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.sIc), Long.valueOf(d.a(d.this)) });
      if (this.sIc == d.a(d.this))
      {
        d.d(d.this).ms(true);
        if (d.i(d.this) == d.b.sIg)
        {
          d.this.a(d.b.sIh);
          k.K(d.a(d.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      ac.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.sIc), Long.valueOf(d.a(d.this)) });
      if (this.sIc == d.a(d.this))
      {
        d.d(d.this).ms(false);
        d.this.a(d.b.sIg);
        k.K(d.a(d.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      sId = new b("None", 0);
      sIe = new b("StartSearch", 1);
      sIf = new b("ReturnResult", 2);
      sIg = new b("StartAnimation", 3);
      sIh = new b("ShowResult", 4);
      sIi = new b("Timeout", 5);
      sIj = new b[] { sId, sIe, sIf, sIg, sIh, sIi };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
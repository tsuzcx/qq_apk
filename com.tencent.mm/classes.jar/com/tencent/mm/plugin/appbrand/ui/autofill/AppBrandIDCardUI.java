package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.c;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import d.y;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int lEN = 2131296738;
  private String appId;
  private int gNs;
  private e hKb;
  public MMFragment lEO;
  private ctg lEP;
  private gx lEQ;
  private LinkedList<Integer> lER;
  private String lES;
  private String lET;
  private String lEU;
  private int lEV;
  private com.tencent.mm.plugin.appbrand.jsapi.a.a.a lEW;
  private p lEX;
  private PhoneItem lEY;
  private a lEy;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.lEy = new a()
    {
      public final void MX(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        ad.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void MY(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        ad.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void MZ(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        ad.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void a(gw paramAnonymousgw)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
        ad.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new b.a();
        ((b.a)localObject).gUU = new cpp();
        ((b.a)localObject).gUV = new cpq();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((b.a)localObject).funcId = 1762;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).atI();
        cpp localcpp = (cpp)((com.tencent.mm.al.b)localObject).gUS.gUX;
        localcpp.dlB = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localcpp.Ejc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localcpp.Ejd = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localcpp.CBK = paramAnonymousgw.CBK;
        localcpp.dca = paramAnonymousgw.dca;
        localcpp.dgo = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lkh)) {
          localcpp.Eje = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dpO);
        }
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.gUT.gUX == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.gUT.gUX });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (cpq)paramAnonymous2b.gUT.gUX;
            if (paramAnonymous2String.Ejf != null)
            {
              ad.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.Ejf.dmD) });
              if (paramAnonymous2String.Ejf.dmD == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.Ejg);
                ad.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.Ejg });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
              AppMethodBeat.o(48926);
              return;
            }
            ad.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, gw paramAnonymousgw)
      {
        AppMethodBeat.i(48938);
        if (bt.isNullOrNil(paramAnonymousString))
        {
          ad.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        ad.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new b.a();
        ((b.a)localObject).gUU = new djr();
        ((b.a)localObject).gUV = new djs();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((b.a)localObject).funcId = 1721;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).atI();
        djr localdjr = (djr)((com.tencent.mm.al.b)localObject).gUS.gUX;
        localdjr.dlB = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdjr.Ejc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdjr.Ejd = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdjr.CBK = paramAnonymousgw.CBK;
        localdjr.dgo = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo;
        localdjr.Ahs = paramAnonymousString;
        localdjr.Ejg = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localdjr.dca = paramAnonymousgw.dca;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lkh)) {
          localdjr.Eje = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dpO);
        }
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.gUT.gUX == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.gUT.gUX });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (djs)paramAnonymous2b.gUT.gUX;
            if (paramAnonymous2String.Ejf != null)
            {
              ad.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.Ejf.dmD), bt.nullAsNil(paramAnonymous2String.Ejf.dmE) });
              com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
              if (paramAnonymous2String.Ejf.dmD == 0)
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
                ad.i("MicroMsg.AppBrandIDCardUI", "verify success");
                ad.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.Dbd });
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2b = r.lkl;
                  r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                }
                paramAnonymous2b = new Intent();
                paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.Ejf.dmD);
                paramAnonymous2b.putExtra("intent_auth_token", paramAnonymous2String.Dbd);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2b);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.Ejf.dmD == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755463));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755462));
              AppMethodBeat.o(48927);
              return;
            }
            ad.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void back()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
        AppMethodBeat.o(48931);
      }
      
      public final void boQ()
      {
        AppMethodBeat.i(48929);
        Object localObject = new b.a();
        ((b.a)localObject).gUU = new ctf();
        ((b.a)localObject).gUV = new ctg();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((b.a)localObject).funcId = 1774;
        ((b.a)localObject).reqCmdId = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).atI();
        ctf localctf = (ctf)((com.tencent.mm.al.b)localObject).gUS.gUX;
        localctf.dlB = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localctf.Ejc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localctf.EkO = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.gUT.gUX == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.gUT.gUX });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (ctg)paramAnonymous2b.gUT.gUX;
            if (paramAnonymous2String.Ejf == null)
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.Ejf.dmD) });
            ad.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.EkP) });
            switch (paramAnonymous2String.EkP)
            {
            default: 
              ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.Ejf.dmD != 0)
                {
                  ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2b = new Intent();
                  paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.Ejf.dmD);
                  paramAnonymous2b.putExtra("intent_err_msg", paramAnonymous2String.Ejf.dmE);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2b);
                  AppBrandIDCardUI.this.finish();
                  AppMethodBeat.o(48922);
                  return;
                }
                AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous2String);
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 0)
                {
                  AppBrandIDCardUI.f(AppBrandIDCardUI.this);
                  AppMethodBeat.o(48922);
                  return;
                }
              } while (AppBrandIDCardUI.e(AppBrandIDCardUI.this) != 1);
              AppBrandIDCardUI.g(AppBrandIDCardUI.this);
              AppMethodBeat.o(48922);
              return;
            }
            ad.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.Ejf.dmD), paramAnonymous2String.Ejf.dmE });
            paramAnonymous2b = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.Ejf.dmD;
            String str = paramAnonymous2String.Ejf.dmE;
            com.tencent.mm.ui.base.h.a(paramAnonymous2b.lEZ, false, paramAnonymous2String.EkQ.desc, paramAnonymous2String.EkQ.title, paramAnonymous2b.lEZ.getString(2131755459), "", new AppBrandIDCardUI.1.2(paramAnonymous2b, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2b));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void boR()
      {
        AppMethodBeat.i(48935);
        ad.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
        if (AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX == null)
        {
          ad.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.dlB);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.cMo);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.DFR);
          localJSONObject.put("package", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.EzS);
          localJSONObject.put("signType", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.nCa);
          localJSONObject.put("paySign", AppBrandIDCardUI.i(AppBrandIDCardUI.this).EkX.DFq);
          com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
          AppBrandJsApiPayService.kfq.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.c()
          {
            public final void l(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
                Object localObject = new b.a();
                ((b.a)localObject).gUU = new czl();
                ((b.a)localObject).gUV = new czm();
                ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((b.a)localObject).funcId = 1721;
                ((b.a)localObject).reqCmdId = 0;
                ((b.a)localObject).respCmdId = 0;
                localObject = ((b.a)localObject).atI();
                czl localczl = (czl)((com.tencent.mm.al.b)localObject).gUS.gUX;
                localczl.dlB = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localczl.Ejc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localczl.Ejd = paramAnonymous2String;
                localczl.dgo = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).lkh)) {
                  localczl.Eje = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dpO);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, com.tencent.mm.al.b paramAnonymous3b)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (paramAnonymous3b.gUT.gUX == null))
                    {
                      ad.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, paramAnonymous3b.gUT.gUX });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (czm)paramAnonymous3b.gUT.gUX;
                    if (paramAnonymous3String.Ejf == null)
                    {
                      ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    ad.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.CBy) });
                    switch (paramAnonymous3String.CBy)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      ad.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.Dbd });
                      com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
                      if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3b = r.lkl;
                        r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3b = new Intent();
                      paramAnonymous3b.putExtra("intent_err_code", paramAnonymous3String.Ejf.dmD);
                      paramAnonymous3b.putExtra("intent_auth_token", paramAnonymous3String.Dbd);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3b);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.Ero);
                      AppBrandIDCardUI.k(AppBrandIDCardUI.this);
                    }
                  }
                });
              }
              for (;;)
              {
                ad.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                AppMethodBeat.o(48925);
                return;
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1)
                {
                  AppBrandIDCardUI.this.setResult(0);
                  AppBrandIDCardUI.this.finish();
                }
              }
            }
          });
          AppMethodBeat.o(48935);
          return;
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
          AppMethodBeat.o(48935);
        }
      }
      
      public final void boS()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.h.vKh.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dgo });
        AppMethodBeat.o(48936);
      }
      
      public final ctg boT()
      {
        AppMethodBeat.i(48939);
        ctg localctg = AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localctg;
      }
      
      public final gx boU()
      {
        AppMethodBeat.i(48940);
        gx localgx = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localgx;
      }
      
      public final void onSwipeBack()
      {
        AppMethodBeat.i(48930);
        AppBrandIDCardUI.this.onSwipeBack();
        AppMethodBeat.o(48930);
      }
    };
    AppMethodBeat.o(48952);
  }
  
  private static LinkedList<Integer> K(Bundle paramBundle)
  {
    AppMethodBeat.i(48960);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      ad.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
      paramBundle = new JSONArray(paramBundle);
      int i = 0;
      while (i < paramBundle.length())
      {
        localLinkedList.add(Integer.valueOf(paramBundle.optInt(i)));
        i += 1;
      }
      AppMethodBeat.o(48960);
      return localLinkedList;
    }
    catch (JSONException paramBundle)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(48960);
    }
    return null;
  }
  
  private void back()
  {
    AppMethodBeat.i(48956);
    if (((this.lEO instanceof AppBrandIDCardVerifyPwdFrag)) && (this.lEV == 0))
    {
      boP();
      AppMethodBeat.o(48956);
      return;
    }
    if ((this.lEV != 1) || (this.hKb == null) || (!this.hKb.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void boP()
  {
    AppMethodBeat.i(48961);
    ad.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.lEO = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.lEO).lEy = this.lEy;
    getSupportFragmentManager().beginTransaction().b(lEN, this.lEO).commitAllowingStateLoss();
    AppMethodBeat.o(48961);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.lEX != null) && (this.lEX.isShowing())) {
      this.lEX.dismiss();
    }
    if ((this.hKb != null) && (this.lEW != null)) {
      this.hKb.c(this.lEW);
    }
    super.finish();
    if (this.lEV == 1) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(48958);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48959);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48959);
      return;
      if (this.lEW != null)
      {
        paramIntent = this.lEW;
        r localr = r.lkl;
        paramIntent.s((ArrayList)r.blD());
        AppMethodBeat.o(48959);
        return;
      }
      ad.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48955);
    back();
    AppMethodBeat.o(48955);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48954);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.lEV = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    super.onCreate(paramBundle);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.appId = ((Bundle)localObject).getString("intent_appid", "");
    if (bt.isNullOrNil(this.appId))
    {
      ad.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.lER = K((Bundle)localObject);
    if ((bt.gL(this.lER)) || (this.lER.size() <= 0))
    {
      ad.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.gNs = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131100705));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(lEN);
    ((ViewGroup)getContentView()).addView((View)localObject, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48944);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
        AppMethodBeat.o(48944);
        return true;
      }
    });
    getString(2131755906);
    this.lEX = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.lEX.show();
    if (this.lEV == 1)
    {
      ai.b(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(lEN).setBackgroundColor(0);
      this.hKb = new e(getContext());
      paramBundle = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      if (!(((ViewGroup)getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup)) {
        break label480;
      }
      ad.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)paramBundle).addView(this.hKb);
        this.lEy.boQ();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        ad.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.hKb);
        continue;
      }
      label480:
      ad.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.hKb);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if (this.lEV == 1) {
      setTheme(2131821149);
    }
    getWindow().requestFeature(10);
    getWindow().getDecorView().setFitsSystemWindows(true);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    AppMethodBeat.o(48953);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48957);
    back();
    AppMethodBeat.o(48957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void MX(String paramString);
    
    public abstract void MY(String paramString);
    
    public abstract void MZ(String paramString);
    
    public abstract void a(gw paramgw);
    
    public abstract void a(String paramString, gw paramgw);
    
    public abstract void back();
    
    public abstract void boQ();
    
    public abstract void boR();
    
    public abstract void boS();
    
    public abstract ctg boT();
    
    public abstract gx boU();
    
    public abstract void onSwipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */
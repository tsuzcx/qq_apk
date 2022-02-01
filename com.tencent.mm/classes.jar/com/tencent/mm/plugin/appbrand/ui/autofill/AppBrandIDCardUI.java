package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.d;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int mHh = 2131296738;
  private String appId;
  private int hGk;
  private e iDP;
  private AppBrandIDCardUI.a mGT;
  public MMFragment mHi;
  private dee mHj;
  private hi mHk;
  private LinkedList<Integer> mHl;
  private String mHm;
  private String mHn;
  private String mHo;
  private int mHp;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a mHq;
  private p mHr;
  private PhoneItem mHs;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.mGT = new AppBrandIDCardUI.a()
    {
      public final void UM(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        ad.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void UN(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        ad.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void UO(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        ad.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void a(hh paramAnonymoushh)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
        ad.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new b.a();
        ((b.a)localObject).hNM = new dag();
        ((b.a)localObject).hNN = new dah();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((b.a)localObject).funcId = 1762;
        ((b.a)localObject).hNO = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDC();
        dag localdag = (dag)((com.tencent.mm.al.b)localObject).hNK.hNQ;
        localdag.duW = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdag.HqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdag.HqB = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdag.FzC = paramAnonymoushh.FzC;
        localdag.dkR = paramAnonymoushh.dkR;
        localdag.dpf = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).mjP)) {
          localdag.HqC = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dzn);
        }
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hNL.hNQ == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hNL.hNQ });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (dah)paramAnonymous2b.hNL.hNQ;
            if (paramAnonymous2String.HqD != null)
            {
              ad.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.HqD.dvY) });
              if (paramAnonymous2String.HqD.dvY == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.HqE);
                ad.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.HqE });
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
      
      public final void a(String paramAnonymousString, hh paramAnonymoushh)
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
        ((b.a)localObject).hNM = new dux();
        ((b.a)localObject).hNN = new duy();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((b.a)localObject).funcId = 1721;
        ((b.a)localObject).hNO = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDC();
        dux localdux = (dux)((com.tencent.mm.al.b)localObject).hNK.hNQ;
        localdux.duW = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdux.HqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdux.HqB = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdux.FzC = paramAnonymoushh.FzC;
        localdux.dpf = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf;
        localdux.Daf = paramAnonymousString;
        localdux.HqE = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localdux.dkR = paramAnonymoushh.dkR;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).mjP)) {
          localdux.HqC = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dzn);
        }
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hNL.hNQ == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hNL.hNQ });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (duy)paramAnonymous2b.hNL.hNQ;
            if (paramAnonymous2String.HqD != null)
            {
              ad.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.HqD.dvY), bt.nullAsNil(paramAnonymous2String.HqD.dvZ) });
              com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
              if (paramAnonymous2String.HqD.dvY == 0)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
                ad.i("MicroMsg.AppBrandIDCardUI", "verify success");
                ad.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.Gbt });
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2b = r.mjT;
                  r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                }
                paramAnonymous2b = new Intent();
                paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.HqD.dvY);
                paramAnonymous2b.putExtra("intent_auth_token", paramAnonymous2String.Gbt);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2b);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.HqD.dvY == 40013)
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
      
      public final void bzR()
      {
        AppMethodBeat.i(48929);
        Object localObject = new b.a();
        ((b.a)localObject).hNM = new ded();
        ((b.a)localObject).hNN = new dee();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((b.a)localObject).funcId = 1774;
        ((b.a)localObject).hNO = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDC();
        ded localded = (ded)((com.tencent.mm.al.b)localObject).hNK.hNQ;
        localded.duW = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localded.HqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localded.Hsu = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((com.tencent.mm.al.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.b paramAnonymous2b)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hNL.hNQ == null))
            {
              ad.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hNL.hNQ });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (dee)paramAnonymous2b.hNL.hNQ;
            if (paramAnonymous2String.HqD == null)
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
            ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.HqD.dvY) });
            ad.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.Hsv) });
            switch (paramAnonymous2String.Hsv)
            {
            default: 
              ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.HqD.dvY != 0)
                {
                  ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2b = new Intent();
                  paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.HqD.dvY);
                  paramAnonymous2b.putExtra("intent_err_msg", paramAnonymous2String.HqD.dvZ);
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
            ad.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.HqD.dvY), paramAnonymous2String.HqD.dvZ });
            paramAnonymous2b = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.HqD.dvY;
            String str = paramAnonymous2String.HqD.dvZ;
            h.a(paramAnonymous2b.mHt, false, paramAnonymous2String.Hsw.desc, paramAnonymous2String.Hsw.title, paramAnonymous2b.mHt.getString(2131755459), "", new AppBrandIDCardUI.1.2(paramAnonymous2b, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2b));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void bzS()
      {
        AppMethodBeat.i(48935);
        ad.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
        if (AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD == null)
        {
          ad.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.duW);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.cUM);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.GKK);
          localJSONObject.put("package", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.HHM);
          localJSONObject.put("signType", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.oIu);
          localJSONObject.put("paySign", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HsD.GKj);
          com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
          AppBrandJsApiPayService.lcw.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.d()
          {
            public final void p(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
                Object localObject = new b.a();
                ((b.a)localObject).hNM = new dkk();
                ((b.a)localObject).hNN = new dkl();
                ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((b.a)localObject).funcId = 1721;
                ((b.a)localObject).hNO = 0;
                ((b.a)localObject).respCmdId = 0;
                localObject = ((b.a)localObject).aDC();
                dkk localdkk = (dkk)((com.tencent.mm.al.b)localObject).hNK.hNQ;
                localdkk.duW = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localdkk.HqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localdkk.HqB = paramAnonymous2String;
                localdkk.dpf = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).mjP)) {
                  localdkk.HqC = bt.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dzn);
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
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (paramAnonymous3b.hNL.hNQ == null))
                    {
                      ad.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, paramAnonymous3b.hNL.hNQ });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (dkl)paramAnonymous3b.hNL.hNQ;
                    if (paramAnonymous3String.HqD == null)
                    {
                      ad.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    ad.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.Fzq) });
                    switch (paramAnonymous3String.Fzq)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      ad.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.Gbt });
                      com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
                      if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3b = r.mjT;
                        r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3b = new Intent();
                      paramAnonymous3b.putExtra("intent_err_code", paramAnonymous3String.HqD.dvY);
                      paramAnonymous3b.putExtra("intent_auth_token", paramAnonymous3String.Gbt);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3b);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.Hzb);
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
      
      public final void bzT()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.g.yhR.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dpf });
        AppMethodBeat.o(48936);
      }
      
      public final dee bzU()
      {
        AppMethodBeat.i(48939);
        dee localdee = AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localdee;
      }
      
      public final hi bzV()
      {
        AppMethodBeat.i(48940);
        hi localhi = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localhi;
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
  
  private static LinkedList<Integer> M(Bundle paramBundle)
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
    if (((this.mHi instanceof AppBrandIDCardVerifyPwdFrag)) && (this.mHp == 0))
    {
      bzQ();
      AppMethodBeat.o(48956);
      return;
    }
    if ((this.mHp != 1) || (this.iDP == null) || (!this.iDP.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void bzQ()
  {
    AppMethodBeat.i(48961);
    ad.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.mHi = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.mHi).mGT = this.mGT;
    getSupportFragmentManager().beginTransaction().b(mHh, this.mHi).commitAllowingStateLoss();
    AppMethodBeat.o(48961);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.mHr != null) && (this.mHr.isShowing())) {
      this.mHr.dismiss();
    }
    if ((this.iDP != null) && (this.mHq != null)) {
      this.iDP.c(this.mHq);
    }
    super.finish();
    if (this.mHp == 1) {
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
      if (this.mHq != null)
      {
        paramIntent = this.mHq;
        r localr = r.mjT;
        paramIntent.setPhoneItems((ArrayList)r.bwx());
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
      this.mHp = ((Bundle)localObject).getInt("id_ui_theme", 0);
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
    this.mHl = M((Bundle)localObject);
    if ((bt.hj(this.mHl)) || (this.mHl.size() <= 0))
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
    this.hGk = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131100705));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(mHh);
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
    this.mHr = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.mHr.show();
    if (this.mHp == 1)
    {
      al.b(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(mHh).setBackgroundColor(0);
      this.iDP = new e(getContext());
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
        ((ViewGroup)paramBundle).addView(this.iDP);
        this.mGT.bzR();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        ad.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.iDP);
        continue;
      }
      label480:
      ad.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.iDP);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if (this.mHp == 1) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.au.j;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.d;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eid;
import com.tencent.mm.protocal.protobuf.eie;
import com.tencent.mm.protocal.protobuf.eot;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.faj;
import com.tencent.mm.protocal.protobuf.fak;
import com.tencent.mm.protocal.protobuf.faw;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int rbe = au.f.app_brand_idcard_container;
  private String appId;
  private int ltN;
  private com.tencent.mm.plugin.appbrand.widget.dialog.d msX;
  private AppBrandIDCardUI.a raQ;
  public MMFragment rbf;
  private String rbg;
  private String rbh;
  private int rbi;
  private String rbj;
  private String rbk;
  private eie rbl;
  private hl rbm;
  private LinkedList<Integer> rbn;
  private String rbo;
  private String rbp;
  private String rbq;
  private int rbr;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a rbs;
  private s rbt;
  private PhoneItem rbu;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.raQ = new AppBrandIDCardUI.a()
    {
      public final void a(hk paramAnonymoushk)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
        Log.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new d.a();
        ((d.a)localObject).lBU = new eei();
        ((d.a)localObject).lBV = new eej();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((d.a)localObject).funcId = 1762;
        ((d.a)localObject).lBW = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).bgN();
        eei localeei = (eei)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
        localeei.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localeei.TZD = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localeei.Uij = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localeei.RMD = paramAnonymoushk.RMD;
        localeei.fvP = paramAnonymoushk.fvP;
        localeei.fAo = AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).qBJ)) {
          localeei.Uik = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).fLC);
        }
        IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.d paramAnonymous2d)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (d.c.b(paramAnonymous2d.lBS) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, d.c.b(paramAnonymous2d.lBS) });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_err_msg), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (eej)d.c.b(paramAnonymous2d.lBS);
            if (paramAnonymous2String.Uil != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.Uil.fHV) });
              if (paramAnonymous2String.Uil.fHV == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.Uim);
                Log.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.Uim });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_verify_send_sms_fail));
              AppMethodBeat.o(48926);
              return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_verify_send_sms_fail));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, hk paramAnonymoushk)
      {
        AppMethodBeat.i(48938);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        Log.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new d.a();
        ((d.a)localObject).lBU = new faj();
        ((d.a)localObject).lBV = new fak();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((d.a)localObject).funcId = 1721;
        ((d.a)localObject).lBW = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).bgN();
        faj localfaj = (faj)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
        localfaj.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localfaj.TZD = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localfaj.Uij = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localfaj.RMD = paramAnonymoushk.RMD;
        localfaj.fAo = AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo;
        localfaj.OTh = paramAnonymousString;
        localfaj.Uim = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        localfaj.fvP = paramAnonymoushk.fvP;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).qBJ)) {
          localfaj.Uik = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).fLC);
        }
        IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.d paramAnonymous2d)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (d.c.b(paramAnonymous2d.lBS) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, d.c.b(paramAnonymous2d.lBS) });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_err_msg), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (fak)d.c.b(paramAnonymous2d.lBS);
            if (paramAnonymous2String.Uil != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.Uil.fHV), Util.nullAsNil(paramAnonymous2String.Uil.fHW) });
              com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
              if (paramAnonymous2String.Uil.fHV == 0)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
                Log.i("MicroMsg.AppBrandIDCardUI", "verify success");
                Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.SqY });
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2d = r.qBN;
                  r.b(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                }
                paramAnonymous2d = new Intent();
                paramAnonymous2d.putExtra("intent_err_code", paramAnonymous2String.Uil.fHV);
                paramAnonymous2d.putExtra("intent_auth_token", paramAnonymous2String.SqY);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2d);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.Uil.fHV == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_verify_err_msg_not_match));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_verify_err_msg_expired));
              AppMethodBeat.o(48927);
              return;
            }
            Log.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void amV(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        Log.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void amW(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        Log.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void amX(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        Log.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void ckA()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48931);
      }
      
      public final void ckC()
      {
        AppMethodBeat.i(48929);
        Object localObject = new d.a();
        ((d.a)localObject).lBU = new eid();
        ((d.a)localObject).lBV = new eie();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((d.a)localObject).funcId = 1774;
        ((d.a)localObject).lBW = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).bgN();
        eid localeid = (eid)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
        localeid.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localeid.TZD = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localeid.auth_type = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.d paramAnonymous2d)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (d.c.b(paramAnonymous2d.lBS) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, d.c.b(paramAnonymous2d.lBS) });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (eie)d.c.b(paramAnonymous2d.lBS);
            if (paramAnonymous2String.Uil == null)
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.Uil.fHV) });
            Log.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.Ukb) });
            switch (paramAnonymous2String.Ukb)
            {
            default: 
              Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.Uil.fHV != 0)
                {
                  Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2d = new Intent();
                  paramAnonymous2d.putExtra("intent_err_code", paramAnonymous2String.Uil.fHV);
                  paramAnonymous2d.putExtra("intent_err_msg", paramAnonymous2String.Uil.fHW);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2d);
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
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1)
                {
                  AppBrandIDCardUI.g(AppBrandIDCardUI.this);
                  AppMethodBeat.o(48922);
                  return;
                }
              } while (AppBrandIDCardUI.e(AppBrandIDCardUI.this) != 2);
              AppBrandIDCardUI.h(AppBrandIDCardUI.this);
              AppMethodBeat.o(48922);
              return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.Uil.fHV), paramAnonymous2String.Uil.fHW });
            paramAnonymous2d = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.Uil.fHV;
            String str = paramAnonymous2String.Uil.fHW;
            com.tencent.mm.ui.base.h.a(paramAnonymous2d.rbv, false, paramAnonymous2String.Ukc.desc, paramAnonymous2String.Ukc.title, paramAnonymous2d.rbv.getString(au.i.app_brand_idcard_show_alert_ok), "", new AppBrandIDCardUI.1.2(paramAnonymous2d, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2d));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void ckD()
      {
        AppMethodBeat.i(48935);
        Log.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
        if (AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki == null)
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.appid);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.fdH);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.Tuh);
          localJSONObject.put("package", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.UAM);
          localJSONObject.put("signType", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.tyH);
          localJSONObject.put("paySign", AppBrandIDCardUI.j(AppBrandIDCardUI.this).Uki.TsD);
          com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
          AppBrandJsApiPayService.pjI.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.d()
          {
            public final void u(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
                Object localObject = new d.a();
                ((d.a)localObject).lBU = new eot();
                ((d.a)localObject).lBV = new eou();
                ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((d.a)localObject).funcId = 1721;
                ((d.a)localObject).lBW = 0;
                ((d.a)localObject).respCmdId = 0;
                localObject = ((d.a)localObject).bgN();
                eot localeot = (eot)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
                localeot.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localeot.TZD = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localeot.Uij = paramAnonymous2String;
                localeot.fAo = AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo;
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).qBJ)) {
                  localeot.Uik = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).fLC);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((com.tencent.mm.an.d)localObject, new IPCRunCgi.a()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, com.tencent.mm.an.d paramAnonymous3d)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (d.c.b(paramAnonymous3d.lBS) == null))
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, d.c.b(paramAnonymous3d.lBS) });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (eou)d.c.b(paramAnonymous3d.lBS);
                    if (paramAnonymous3String.Uil == null)
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(au.i.app_brand_idcard_err_msg), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    Log.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.RMr) });
                    switch (paramAnonymous3String.RMr)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.SqY });
                      com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
                      if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3d = r.qBN;
                        r.b(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3d = new Intent();
                      paramAnonymous3d.putExtra("intent_err_code", paramAnonymous3String.Uil.fHV);
                      paramAnonymous3d.putExtra("intent_auth_token", paramAnonymous3String.SqY);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3d);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.Urp);
                      AppBrandIDCardUI.l(AppBrandIDCardUI.this);
                    }
                  }
                });
              }
              for (;;)
              {
                Log.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                AppMethodBeat.o(48925);
                return;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2))
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
          Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
          AppMethodBeat.o(48935);
        }
      }
      
      public final void ckE()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.h.IzE.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.j(AppBrandIDCardUI.this).fAo });
        AppMethodBeat.o(48936);
      }
      
      public final eie ckF()
      {
        AppMethodBeat.i(48939);
        eie localeie = AppBrandIDCardUI.j(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localeie;
      }
      
      public final hl ckG()
      {
        AppMethodBeat.i(48940);
        hl localhl = AppBrandIDCardUI.o(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localhl;
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
  
  private void CV(int paramInt)
  {
    AppMethodBeat.i(282079);
    com.tencent.mm.plugin.report.service.h.IzE.a(21655, new Object[] { Integer.valueOf(this.rbi), this.rbj, Integer.valueOf(paramInt), this.rbk });
    AppMethodBeat.o(282079);
  }
  
  private static LinkedList<Integer> V(Bundle paramBundle)
  {
    AppMethodBeat.i(48960);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      Log.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
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
      Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(48960);
    }
    return null;
  }
  
  private void ckA()
  {
    AppMethodBeat.i(48956);
    if (((this.rbf instanceof AppBrandIDCardVerifyPwdFrag)) && (this.rbr == 0))
    {
      ckB();
      AppMethodBeat.o(48956);
      return;
    }
    if (((this.rbr != 1) && (this.rbr != 2)) || (this.msX == null) || (!this.msX.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void ckB()
  {
    AppMethodBeat.i(48961);
    Log.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.rbf = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.rbf).raQ = this.raQ;
    getSupportFragmentManager().beginTransaction().b(rbe, this.rbf).ip();
    AppMethodBeat.o(48961);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.rbt != null) && (this.rbt.isShowing())) {
      this.rbt.dismiss();
    }
    if ((this.msX != null) && (this.rbs != null)) {
      this.msX.b(this.rbs);
    }
    super.finish();
    if ((this.rbr == 1) || (this.rbr == 2)) {
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
    Log.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48959);
      return;
      if (this.rbs != null)
      {
        paramIntent = this.rbs;
        r localr = r.qBN;
        paramIntent.setPhoneItems((ArrayList)r.cgD());
        AppMethodBeat.o(48959);
        return;
      }
      Log.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48955);
    ckA();
    AppMethodBeat.o(48955);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48954);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.rbr = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    super.onCreate(paramBundle);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.appId = ((Bundle)localObject).getString("intent_appid", "");
    this.rbg = ((Bundle)localObject).getString("wecoin_protocol_url", "");
    this.rbh = ((Bundle)localObject).getString("wecoin_apply_info", "");
    this.rbi = ((Bundle)localObject).getInt("wecoin_kv_scene_id", 1);
    this.rbj = ((Bundle)localObject).getString("wecoin_kv_session_id", "");
    this.rbk = ((Bundle)localObject).getString("wecoin_kv_cgi_session_id", "");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.rbn = V((Bundle)localObject);
    if ((Util.isNullOrNil(this.rbn)) || (this.rbn.size() <= 0))
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.ltN = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(au.c.normal_actionbar_color));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(rbe);
    ((ViewGroup)getContentView()).addView((View)localObject, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48944);
        AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48944);
        return true;
      }
    });
    getString(au.i.app_tip);
    this.rbt = com.tencent.mm.ui.base.h.a(this, getString(au.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.rbt.show();
    if ((this.rbr == 1) || (this.rbr == 2))
    {
      ar.e(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(rbe).setBackgroundColor(0);
      this.msX = new com.tencent.mm.plugin.appbrand.widget.dialog.d(getContext());
      paramBundle = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      if (!(((ViewGroup)getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup)) {
        break label552;
      }
      Log.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)paramBundle).addView(this.msX);
        this.raQ.ckC();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        Log.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.msX);
        continue;
      }
      label552:
      Log.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.msX);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if ((this.rbr == 1) || (this.rbr == 2)) {
      setTheme(au.j.MMTheme_NoTitleTranslucent);
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
    ckA();
    AppMethodBeat.o(48957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */
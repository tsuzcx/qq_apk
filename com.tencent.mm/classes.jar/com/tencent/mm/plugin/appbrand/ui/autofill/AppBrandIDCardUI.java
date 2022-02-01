package com.tencent.mm.plugin.appbrand.ui.autofill;

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
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.d;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.protocal.protobuf.exz;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.protocal.protobuf.fcf;
import com.tencent.mm.protocal.protobuf.fcg;
import com.tencent.mm.protocal.protobuf.fjs;
import com.tencent.mm.protocal.protobuf.fjt;
import com.tencent.mm.protocal.protobuf.fwn;
import com.tencent.mm.protocal.protobuf.fwo;
import com.tencent.mm.protocal.protobuf.fxc;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.ah;
import kotlin.g.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int ugT = ba.f.app_brand_idcard_container;
  private String appId;
  private int olm;
  private g pmu;
  private String tBx;
  private a ugH;
  public MMFragment ugU;
  private String ugV;
  private String ugW;
  private int ugX;
  private String ugY;
  private String ugZ;
  private fcg uha;
  private ih uhb;
  private LinkedList<Integer> uhc;
  private String uhd;
  private String uhe;
  private int uhf;
  private boolean uhg;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.a uhh;
  private w uhi;
  private PhoneItem uhj;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.uhg = false;
    this.ugH = new a()
    {
      public final void a(ig paramAnonymousig)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
        Log.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new c.a();
        ((c.a)localObject).otE = new exz();
        ((c.a)localObject).otF = new eya();
        ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((c.a)localObject).funcId = 1762;
        ((c.a)localObject).otG = 0;
        ((c.a)localObject).respCmdId = 0;
        localObject = ((c.a)localObject).bEF();
        exz localexz = (exz)c.b.b(((c)localObject).otB);
        localexz.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localexz.abqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localexz.abzy = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localexz.YJR = paramAnonymousig.YJR;
        localexz.hAk = paramAnonymousig.hAk;
        localexz.hFb = AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).tGO)) {
          localexz.abzz = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).hRk);
        }
        IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
        {
          public final void callback(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, c paramAnonymous2c)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (c.c.b(paramAnonymous2c.otC) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.c.b(paramAnonymous2c.otC) });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_err_msg), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (eya)c.c.b(paramAnonymous2c.otC);
            if (paramAnonymous2String.abzA != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.abzA.hNv) });
              if (paramAnonymous2String.abzA.hNv == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.abzB);
                Log.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.abzB });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_verify_send_sms_fail));
              AppMethodBeat.o(48926);
              return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_verify_send_sms_fail));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, ig paramAnonymousig)
      {
        AppMethodBeat.i(48938);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        Log.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new c.a();
        ((c.a)localObject).otE = new fwn();
        ((c.a)localObject).otF = new fwo();
        ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((c.a)localObject).funcId = 1721;
        ((c.a)localObject).otG = 0;
        ((c.a)localObject).respCmdId = 0;
        localObject = ((c.a)localObject).bEF();
        fwn localfwn = (fwn)c.b.b(((c)localObject).otB);
        localfwn.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localfwn.abqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localfwn.abzy = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localfwn.YJR = paramAnonymousig.YJR;
        localfwn.hFb = AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb;
        localfwn.VJo = paramAnonymousString;
        localfwn.abzB = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        localfwn.hAk = paramAnonymousig.hAk;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).tGO)) {
          localfwn.abzz = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).hRk);
        }
        IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
        {
          public final void callback(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, c paramAnonymous2c)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (c.c.b(paramAnonymous2c.otC) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.c.b(paramAnonymous2c.otC) });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_err_msg), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (fwo)c.c.b(paramAnonymous2c.otC);
            if (paramAnonymous2String.abzA != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.abzA.hNv), Util.nullAsNil(paramAnonymous2String.abzA.hNw) });
              com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
              if (paramAnonymous2String.abzA.hNv == 0)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
                Log.i("MicroMsg.AppBrandIDCardUI", "verify success");
                Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.ZpZ });
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2c = com.tencent.mm.plugin.appbrand.phonenumber.r.tGQ;
                  com.tencent.mm.plugin.appbrand.phonenumber.r.c(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                }
                paramAnonymous2c = new Intent();
                paramAnonymous2c.putExtra("intent_err_code", paramAnonymous2String.abzA.hNv);
                paramAnonymous2c.putExtra("intent_auth_token", paramAnonymous2String.ZpZ);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2c);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.abzA.hNv == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_verify_err_msg_not_match));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_verify_err_msg_expired));
              AppMethodBeat.o(48927);
              return;
            }
            Log.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void agj(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        Log.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void agk(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        Log.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void agl(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        Log.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void cLO()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48931);
      }
      
      public final void cLQ()
      {
        AppMethodBeat.i(48929);
        Object localObject = new c.a();
        ((c.a)localObject).otE = new fcf();
        ((c.a)localObject).otF = new fcg();
        ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((c.a)localObject).funcId = 1774;
        ((c.a)localObject).otG = 0;
        ((c.a)localObject).respCmdId = 0;
        localObject = ((c.a)localObject).bEF();
        fcf localfcf = (fcf)c.b.b(((c)localObject).otB);
        localfcf.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localfcf.abqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localfcf.auth_type = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
        {
          public final void callback(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, c paramAnonymous2c)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (c.c.b(paramAnonymous2c.otC) == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, c.c.b(paramAnonymous2c.otC) });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (fcg)c.c.b(paramAnonymous2c.otC);
            if (paramAnonymous2String.abzA == null)
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
            Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.abzA.hNv) });
            Log.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.abBK) });
            switch (paramAnonymous2String.abBK)
            {
            default: 
              Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.abzA.hNv != 0)
                {
                  Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2c = new Intent();
                  paramAnonymous2c.putExtra("intent_err_code", paramAnonymous2String.abzA.hNv);
                  paramAnonymous2c.putExtra("intent_err_msg", paramAnonymous2String.abzA.hNw);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2c);
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
            Log.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.abzA.hNv), paramAnonymous2String.abzA.hNw });
            paramAnonymous2c = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.abzA.hNv;
            String str = paramAnonymous2String.abzA.hNw;
            k.a(paramAnonymous2c.uhk, false, paramAnonymous2String.abBL.desc, paramAnonymous2String.abBL.title, paramAnonymous2c.uhk.getString(ba.i.app_brand_idcard_show_alert_ok), "", new AppBrandIDCardUI.1.2(paramAnonymous2c, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2c));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void cLR()
      {
        AppMethodBeat.i(48935);
        Log.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
        if (AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR == null)
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.appid);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.hhx);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.aaIL);
          localJSONObject.put("package", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.abUP);
          localJSONObject.put("signType", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.wDe);
          localJSONObject.put("paySign", AppBrandIDCardUI.j(AppBrandIDCardUI.this).abBR.aaGN);
          com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
          AppBrandJsApiPayService.soM.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.d()
          {
            public final void G(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
                Object localObject = new c.a();
                ((c.a)localObject).otE = new fjs();
                ((c.a)localObject).otF = new fjt();
                ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((c.a)localObject).funcId = 1721;
                ((c.a)localObject).otG = 0;
                ((c.a)localObject).respCmdId = 0;
                localObject = ((c.a)localObject).bEF();
                fjs localfjs = (fjs)c.b.b(((c)localObject).otB);
                localfjs.appid = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localfjs.abqA = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localfjs.abzy = paramAnonymous2String;
                localfjs.hFb = AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb;
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).tGO)) {
                  localfjs.abzz = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).hRk);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
                {
                  public final void callback(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, c paramAnonymous3c)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (c.c.b(paramAnonymous3c.otC) == null))
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, c.c.b(paramAnonymous3c.otC) });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (fjt)c.c.b(paramAnonymous3c.otC);
                    if (paramAnonymous3String.abzA == null)
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(ba.i.app_brand_idcard_err_msg), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    Log.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.YJF) });
                    switch (paramAnonymous3String.YJF)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.ZpZ });
                      com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
                      if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3c = com.tencent.mm.plugin.appbrand.phonenumber.r.tGQ;
                        com.tencent.mm.plugin.appbrand.phonenumber.r.c(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3c = new Intent();
                      paramAnonymous3c.putExtra("intent_err_code", paramAnonymous3String.abzA.hNv);
                      paramAnonymous3c.putExtra("intent_auth_token", paramAnonymous3String.ZpZ);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3c);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.abKp);
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
      
      public final void cLS()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.h.OAn.b(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.j(AppBrandIDCardUI.this).hFb });
        AppMethodBeat.o(48936);
      }
      
      public final fcg cLT()
      {
        AppMethodBeat.i(48939);
        fcg localfcg = AppBrandIDCardUI.j(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localfcg;
      }
      
      public final ih cLU()
      {
        AppMethodBeat.i(48940);
        ih localih = AppBrandIDCardUI.o(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localih;
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
  
  private void Dp(int paramInt)
  {
    AppMethodBeat.i(322634);
    com.tencent.mm.plugin.report.service.h.OAn.b(21655, new Object[] { Integer.valueOf(this.ugX), this.ugY, Integer.valueOf(paramInt), this.ugZ });
    AppMethodBeat.o(322634);
  }
  
  private static LinkedList<Integer> ag(Bundle paramBundle)
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
  
  private void cLO()
  {
    AppMethodBeat.i(48956);
    if (((this.ugU instanceof AppBrandIDCardVerifyPwdFrag)) && (this.uhf == 0))
    {
      cLP();
      AppMethodBeat.o(48956);
      return;
    }
    if (((this.uhf != 1) && (this.uhf != 2)) || (this.pmu == null) || (!this.pmu.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void cLP()
  {
    AppMethodBeat.i(48961);
    Log.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(322627);
        AppBrandIDCardUI.this.ugU = new AppBrandIDCardShowFrag();
        ((AppBrandIDCardShowFrag)AppBrandIDCardUI.this.ugU).ugH = AppBrandIDCardUI.p(AppBrandIDCardUI.this);
        AppBrandIDCardUI.this.getSupportFragmentManager().beginTransaction().b(AppBrandIDCardUI.ugT, AppBrandIDCardUI.this.ugU).FX();
        AppMethodBeat.o(322627);
      }
    });
    AppMethodBeat.o(48961);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.uhi != null) && (this.uhi.isShowing())) {
      this.uhi.dismiss();
    }
    if ((this.pmu != null) && (this.uhh != null)) {
      this.pmu.c(this.uhh);
    }
    super.finish();
    if ((this.uhf == 1) || (this.uhf == 2)) {
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
      if (this.uhh != null)
      {
        paramIntent = this.uhh;
        com.tencent.mm.plugin.appbrand.phonenumber.r localr = com.tencent.mm.plugin.appbrand.phonenumber.r.tGQ;
        paramIntent.setPhoneItems((ArrayList)com.tencent.mm.plugin.appbrand.phonenumber.r.cHA());
        AppMethodBeat.o(48959);
        return;
      }
      Log.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48955);
    cLO();
    AppMethodBeat.o(48955);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48954);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.uhf = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    if ((this.uhf == 1) || (this.uhf == 2)) {
      setTheme(ba.j.MMTheme_NoTitleTranslucent);
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
    this.ugV = ((Bundle)localObject).getString("wecoin_protocol_url", "");
    this.ugW = ((Bundle)localObject).getString("wecoin_apply_info", "");
    this.ugX = ((Bundle)localObject).getInt("wecoin_kv_scene_id", 1);
    this.ugY = ((Bundle)localObject).getString("wecoin_kv_session_id", "");
    this.ugZ = ((Bundle)localObject).getString("wecoin_kv_cgi_session_id", "");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.uhc = ag((Bundle)localObject);
    if ((Util.isNullOrNil(this.uhc)) || (this.uhc.size() <= 0))
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
    this.olm = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(ba.c.normal_actionbar_color));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(ugT);
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
    getString(ba.i.app_tip);
    this.uhi = k.a(this, getString(ba.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.uhi.show();
    if ((this.uhf == 1) || (this.uhf == 2))
    {
      aw.g(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(ugT).setBackgroundColor(0);
      this.pmu = new g(getContext());
      localObject = (ViewGroup)getWindow().getDecorView();
      paramBundle = ((ViewGroup)localObject).getChildAt(0);
      if ((!(paramBundle instanceof ViewGroup)) || (!this.uhg)) {
        break label619;
      }
      if ((paramBundle instanceof FrameLayout)) {
        break label658;
      }
      paramBundle = new FrameLayout(paramBundle.getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.bottomMargin = aw.iu(getContext());
      ((ViewGroup)localObject).addView(paramBundle, localLayoutParams);
    }
    label658:
    for (;;)
    {
      Log.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
      for (;;)
      {
        try
        {
          ((ViewGroup)paramBundle).addView(this.pmu);
          this.ugH.cLQ();
          if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
          }
          AppMethodBeat.o(48954);
          return;
        }
        catch (Exception paramBundle)
        {
          Log.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
          ((ViewGroup)getContentView()).addView(this.pmu);
          continue;
        }
        label619:
        Log.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview, request overlay: %b", new Object[] { Boolean.valueOf(this.uhg) });
        ((ViewGroup)getContentView()).addView(this.pmu);
      }
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if ((this.uhf == 1) || (this.uhf == 2)) {
      setTheme(ba.j.MMTheme_NoTitleTranslucent);
    }
    try
    {
      getWindow().requestFeature(10);
      this.uhg = true;
      getWindow().getDecorView().setFitsSystemWindows(true);
      supportRequestWindowFeature(10);
      supportRequestWindowFeature(1);
      AppMethodBeat.o(48953);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrandIDCardUI", "request overlay failed", new Object[] { localObject });
        this.uhg = false;
      }
    }
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48957);
    cLO();
    AppMethodBeat.o(48957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(ig paramig);
    
    public abstract void a(String paramString, ig paramig);
    
    public abstract void agj(String paramString);
    
    public abstract void agk(String paramString);
    
    public abstract void agl(String paramString);
    
    public abstract void cLO();
    
    public abstract void cLQ();
    
    public abstract void cLR();
    
    public abstract void cLS();
    
    public abstract fcg cLT();
    
    public abstract ih cLU();
    
    public abstract void onSwipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */
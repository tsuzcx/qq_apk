package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hv;
import com.tencent.mm.h.a.hv.b;
import com.tencent.mm.h.a.hw;
import com.tencent.mm.h.a.hw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class i
  extends ContentObserver
  implements f
{
  private String bSe;
  private boolean edT = false;
  private ContentResolver fiK;
  private boolean fiL = false;
  private boolean fiM = false;
  private c fiN = null;
  private final i.a fiO;
  private x fiP;
  private x fiQ;
  private com.tencent.mm.modelfriend.a fiR;
  private com.tencent.mm.modelfriend.a fiS;
  private String fiT;
  private String fiU;
  private boolean fiV = false;
  private View fiW;
  private ProgressBar fiX;
  private String fiY = null;
  private String[] fiZ;
  public boolean fja = true;
  private i.b fjb;
  private ah fjc = new i.1(this);
  private Context mContext;
  private int progress = 0;
  
  public i(i.b paramb, Context paramContext, i.a parama)
  {
    super(ah.fetchFreeHandler());
    this.fjb = paramb;
    this.fiV = false;
    this.mContext = paramContext;
    this.fiZ = this.mContext.getResources().getStringArray(a.a.sms_content);
    this.fiW = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.e.progress_dialog_view, null);
    this.fiX = ((ProgressBar)this.fiW.findViewById(a.d.progress_dialog_bar));
    this.fiO = parama;
  }
  
  private String Xu()
  {
    String str = "( ";
    int i = 0;
    if (i < this.fiZ.length)
    {
      if (i == this.fiZ.length - 1) {}
      for (str = str + " body like \"%" + this.fiZ[i] + "%\" ) ";; str = str + "body like \"%" + this.fiZ[i] + "%\" or ")
      {
        i += 1;
        break;
      }
    }
    str = str + " and date > " + (System.currentTimeMillis() - 300000L) + " ";
    y.v("MicroMsg.SmsBindMobileObserver", "sql where:" + str);
    return str;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    switch (((x)paramm).rN())
    {
    default: 
      return;
    }
    if (((((x)paramm).rN() == 2) || (((x)paramm).rN() == 19)) && (this.fiN != null)) {
      this.fiN.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((((x)paramm).rN() == 2) || (((x)paramm).rN() == 19))
      {
        if (this.fja) {
          ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Bundle();
        if (((x)paramm).rN() == 2)
        {
          y.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", new Object[] { ((x)paramm).NJ() });
          paramString.putString("setpwd_ticket", ((x)paramm).NJ());
        }
        d(1, paramString);
        return;
      }
      if ((((x)paramm).rN() == 1) || (((x)paramm).rN() == 18))
      {
        y.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bSe);
        return;
      }
    }
    if (w(paramInt2, paramString))
    {
      if (this.fiN != null) {
        this.fiN.dismiss();
      }
      this.edT = true;
      return;
    }
    if (((x)paramm).rN() == 2)
    {
      if (this.fiN != null) {
        this.fiN.dismiss();
      }
      this.edT = true;
      d(2, new Bundle());
      return;
    }
    this.edT = true;
    if (this.fiN != null) {
      this.fiN.dismiss();
    }
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null)
    {
      paramString.a(this.mContext, null, null);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(a.h.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    if ((this.fjb == i.b.fjf) || (this.fjb == i.b.fjg)) {
      g.Dk().a(132, this);
    }
    for (;;)
    {
      if (this.fiO != null) {
        this.fiO.d(paramInt, paramBundle);
      }
      return;
      g.Dk().a(145, this);
    }
  }
  
  private boolean w(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case -57: 
    case -1: 
    case -34: 
    case -43: 
    case -214: 
    case -41: 
    case -35: 
    case -36: 
    case -59: 
    case -4: 
      do
      {
        return false;
        Toast.makeText(this.mContext, a.h.app_err_system_busy_tip, 0).show();
        return true;
        Toast.makeText(this.mContext, a.h.bind_mcontact_err_freq_limit, 0).show();
        return true;
        y.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
        this.edT = true;
        if ((i.b.fjf == this.fjb) || (this.fjb == i.b.fjg))
        {
          g.DP().Dz().o(4097, "");
          g.DP().Dz().o(6, this.bSe);
          ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        d(1, new Bundle());
        Toast.makeText(this.mContext, a.h.bind_mcontact_err_binded, 0).show();
        return true;
        paramString = com.tencent.mm.i.a.eI(paramString);
        if (paramString != null) {
          paramString.a(this.mContext, null, null);
        }
        return true;
        Toast.makeText(this.mContext, a.h.bind_mcontact_err_format, 0).show();
        return true;
        if (this.fjb == i.b.fje) {
          d(3, new Bundle());
        }
        for (;;)
        {
          return true;
          h.a(this.mContext, a.h.bind_mcontact_err_binded_by_other, a.h.bind_mcontact_verify_tip, new i.2(this));
        }
        Toast.makeText(this.mContext, a.h.bind_mcontact_err_unbinded_notbinded, 0).show();
        return true;
        h.a(this.mContext, a.h.bind_mcontact_err_not_suport_country, a.h.app_tip, null);
        return true;
      } while (!this.fiV);
      d(6, new Bundle());
      return true;
    }
    h.a(this.mContext, a.h.bind_mcontact_err_BindPhone_NeedAdjust, a.h.app_tip, null);
    return true;
  }
  
  public final void Xt()
  {
    y.v("MicroMsg.SmsBindMobileObserver", "sms number:" + this.fiT);
    if ((this.fiL) || (this.edT) || (this.fiM)) {}
    Object localObject2;
    for (;;)
    {
      return;
      Object localObject1 = Uri.parse("content://sms/inbox");
      this.fiK = this.mContext.getContentResolver();
      localObject3 = Xu();
      if ((localObject3 != null) && (!((String)localObject3).equals(""))) {
        try
        {
          localObject1 = this.fiK.query((Uri)localObject1, new String[] { "body", "_id", "date" }, (String)localObject3, null, null);
          if (localObject1 != null)
          {
            i = -1;
            long l1 = 0L;
            while (((Cursor)localObject1).moveToNext())
            {
              long l2 = ((Cursor)localObject1).getLong(2);
              if (l2 > l1)
              {
                i = ((Cursor)localObject1).getPosition();
                l1 = l2;
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.SmsBindMobileObserver", "get sms failed");
            y.printErrStackTrace("MicroMsg.SmsBindMobileObserver", localException, "", new Object[0]);
            localObject2 = null;
          }
          this.fiU = null;
          if (i < 0) {
            break label436;
          }
        }
      }
    }
    this.fiM = true;
    localObject2.moveToPosition(i);
    Object localObject3 = localObject2.getString(localObject2.getColumnIndex("body"));
    localObject3 = Pattern.compile("\\d{4,8}").matcher((CharSequence)localObject3);
    Object localObject4;
    if (((Matcher)localObject3).find())
    {
      localObject3 = ((Matcher)localObject3).group();
      this.fiU = ((String)localObject3);
      if (this.fiN != null) {
        this.fiN.setCancelable(true);
      }
      if ((this.fjb != i.b.fjf) && (this.fjb != i.b.fjg)) {
        break label450;
      }
      localObject3 = new hv();
      ((hv)localObject3).bPQ.context = this.mContext;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject3);
      localObject3 = ((hv)localObject3).bPR.bPS;
      localObject4 = new hw();
      com.tencent.mm.sdk.b.a.udP.m((b)localObject4);
      localObject4 = ((hw)localObject4).bPT.bPU;
      if (this.fjb != i.b.fjg) {
        break label509;
      }
    }
    label436:
    label450:
    label509:
    for (int i = 19;; i = 2)
    {
      this.fiP = new x(this.bSe, i, this.fiU, "", (String)localObject3, (String)localObject4);
      g.Dk().a(this.fiP, 0);
      localObject2.close();
      return;
      localObject3 = null;
      break;
      localObject3 = this.bSe;
      if (this.fiV) {}
      for (i = 9;; i = 6)
      {
        this.fiR = new com.tencent.mm.modelfriend.a((String)localObject3, i, this.fiU, 0, "");
        g.Dk().a(this.fiR, 0);
        break;
      }
    }
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if ((this.mContext instanceof Activity))
    {
      paramBoolean = com.tencent.mm.pluginsdk.permission.a.a((Activity)this.mContext, "android.permission.READ_SMS", 128, "", "");
      y.i("MicroMsg.SmsBindMobileObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb(), this.mContext });
      if (!paramBoolean) {
        return;
      }
    }
    Xt();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((!paramm.equals(this.fiP)) && (!paramm.equals(this.fiQ)) && (!paramm.equals(this.fiR)) && (!paramm.equals(this.fiS))) {
      y.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.edT);
      if ((paramInt1 == 1) || (paramInt1 == 2))
      {
        y.d("MicroMsg.SmsBindMobileObserver", "error net");
        if (this.fiN != null) {
          this.fiN.dismiss();
        }
        d(4, new Bundle());
        return;
      }
      if ((i.b.fjf == this.fjb) && (paramm.getType() == 132))
      {
        d(paramInt1, paramInt2, paramString, paramm);
        return;
      }
      if ((i.b.fjg == this.fjb) && (paramm.getType() == 132))
      {
        d(paramInt1, paramInt2, paramString, paramm);
        return;
      }
      if ((i.b.fje != this.fjb) || (paramm.getType() != 145)) {
        break label733;
      }
      switch (((com.tencent.mm.modelfriend.a)paramm).rN())
      {
      case 7: 
      default: 
        return;
      }
      if (((((com.tencent.mm.modelfriend.a)paramm).rN() == 6) || (((com.tencent.mm.modelfriend.a)paramm).rN() == 9)) && (this.fiN != null)) {
        this.fiN.dismiss();
      }
      i = ((m.b)((com.tencent.mm.modelfriend.a)paramm).edR.HF()).spT.sBB;
      if (((paramInt1 != 0) || (paramInt2 != 0)) && ((paramInt2 != -35) || (i != 1))) {
        break;
      }
      if (((com.tencent.mm.modelfriend.a)paramm).rN() == 6)
      {
        this.fiY = ((com.tencent.mm.modelfriend.a)paramm).NJ();
        y.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.fiY);
        d(1, new Bundle());
        return;
      }
      if (((com.tencent.mm.modelfriend.a)paramm).rN() == 9)
      {
        this.fiY = ((com.tencent.mm.modelfriend.a)paramm).NJ();
        y.d("MicroMsg.SmsBindMobileObserver", "NetSceneBindOpMobileForReg ticket: " + this.fiY);
        ((com.tencent.mm.modelfriend.a)paramm).getUsername();
        ((com.tencent.mm.modelfriend.a)paramm).NI();
        return;
      }
      if ((((com.tencent.mm.modelfriend.a)paramm).rN() != 5) && (((com.tencent.mm.modelfriend.a)paramm).rN() != 8)) {
        break;
      }
      y.v("MicroMsg.SmsBindMobileObserver", "mobile:" + this.bSe);
    } while ((((com.tencent.mm.modelfriend.a)paramm).rN() != 5) || (paramInt2 != -35) || (i != 1));
    this.fiV = true;
    d(5, new Bundle());
    return;
    if ((((com.tencent.mm.modelfriend.a)paramm).rN() == 6) || (((com.tencent.mm.modelfriend.a)paramm).rN() == 9))
    {
      if (this.fiN != null) {
        this.fiN.dismiss();
      }
      this.edT = true;
      d(2, new Bundle());
      return;
    }
    if (w(paramInt2, paramString))
    {
      if (this.fiN != null) {
        this.fiN.dismiss();
      }
      this.edT = true;
      return;
    }
    this.edT = true;
    if (this.fiN != null) {
      this.fiN.dismiss();
    }
    Toast.makeText(this.mContext, this.mContext.getString(a.h.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    return;
    label733:
    Assert.assertTrue("code path should not be here!", false);
  }
  
  public final void pV(String paramString)
  {
    int i;
    if ((this.fjb == i.b.fjf) || (this.fjb == i.b.fjg))
    {
      g.Dk().a(132, this);
      this.bSe = paramString;
      this.fiL = false;
      this.fiM = false;
      this.fiT = "";
      this.edT = false;
      if ((this.fjb != i.b.fjf) && (this.fjb != i.b.fjg)) {
        break label206;
      }
      i = 1;
      if (this.fjb == i.b.fjg) {
        i = 18;
      }
      this.fiQ = new x(this.bSe, i, "", 0, "");
      g.Dk().a(this.fiQ, 0);
      if (this.fiN != null) {
        break label261;
      }
      this.fiN = h.a(this.mContext, false, this.mContext.getString(a.h.bind_mcontact_verifing), this.fiW, "", "", null, null);
    }
    for (;;)
    {
      this.progress = 0;
      this.fiX.setIndeterminate(false);
      this.fjc.sendEmptyMessage(1000);
      return;
      g.Dk().a(145, this);
      break;
      label206:
      paramString = this.bSe;
      if (this.fiV) {}
      for (i = 8;; i = 5)
      {
        this.fiS = new com.tencent.mm.modelfriend.a(paramString, i, "", 0, "");
        g.Dk().a(this.fiS, 0);
        break;
      }
      label261:
      this.fiN.show();
    }
  }
  
  public final void recycle()
  {
    g.Dk().b(132, this);
    g.Dk().b(145, this);
    this.mContext = null;
    this.edT = true;
    if (this.fiN != null) {
      this.fiN.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.i
 * JD-Core Version:    0.7.0.1
 */
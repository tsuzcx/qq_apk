package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.f.e;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private Bitmap Hom;
  private boolean JLK;
  private TextView JQa;
  private TextView JQb;
  private LinearLayout JQc;
  private LinearLayout JQd;
  private TextView JQe;
  private TextView JQf;
  private TextView JQg;
  private TextView JQh;
  private TextView JQi;
  private Button JQj;
  private String JQk;
  private String JQl;
  private boolean JQm;
  private Cursor JQn;
  private boolean JQo;
  private e JQp;
  private String iaX;
  private String idl;
  private ImageView lKK;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(26007);
    this.JLK = false;
    this.JQn = null;
    this.JQo = false;
    this.JQp = new e();
    AppMethodBeat.o(26007);
  }
  
  private void a(k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26014);
    View localView = LayoutInflater.from(this).inflate(R.i.gnl, this.JQd, false);
    TextView localTextView1 = (TextView)localView.findViewById(R.h.fTz);
    TextView localTextView2 = (TextView)localView.findViewById(R.h.fTB);
    TextView localTextView3 = (TextView)localView.findViewById(R.h.fTC);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.si(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.a.c.se(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(R.g.foS));
        int i = getResources().getDimensionPixelSize(R.f.flQ);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.cd.a.br(getContext(), R.f.flP);
        localView.setLayoutParams(paramk);
      }
      this.JQd.addView(localView);
      AppMethodBeat.o(26014);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.Zv(paramk.field_status));
    }
  }
  
  /* Error */
  private static String aJq(String paramString)
  {
    // Byte code:
    //   0: sipush 26011
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 306	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: ldc_w 308
    //   12: invokestatic 314	com/tencent/mm/pluginsdk/permission/b:s	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +20 -> 35
    //   18: ldc_w 316
    //   21: ldc_w 318
    //   24: invokestatic 324	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 26011
    //   30: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 306	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   38: invokevirtual 330	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 336	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 338
    //   48: iconst_1
    //   49: anewarray 340	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: aconst_null
    //   57: invokevirtual 346	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnonnull +11 -> 75
    //   67: sipush 26011
    //   70: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload 4
    //   77: invokeinterface 352 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +152 -> 236
    //   87: ldc_w 354
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 357 1 0
    //   102: ifne +138 -> 240
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: aload 4
    //   111: ldc_w 359
    //   114: invokeinterface 363 2 0
    //   119: invokeinterface 366 2 0
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: new 368	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 375
    //   145: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: invokeinterface 382 1 0
    //   161: pop
    //   162: goto -71 -> 91
    //   165: astore_0
    //   166: ldc_w 316
    //   169: ldc_w 384
    //   172: iconst_2
    //   173: anewarray 262	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 387	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: invokevirtual 391	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 396	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 399	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: invokeinterface 402 1 0
    //   203: aload_2
    //   204: astore_0
    //   205: aload_2
    //   206: ldc_w 375
    //   209: invokevirtual 405	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: iflt +16 -> 228
    //   215: aload_2
    //   216: iconst_0
    //   217: aload_2
    //   218: ldc_w 375
    //   221: invokevirtual 405	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 409	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_0
    //   228: sipush 26011
    //   231: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: areturn
    //   236: ldc_w 354
    //   239: astore_3
    //   240: aload 4
    //   242: invokeinterface 402 1 0
    //   247: aload_3
    //   248: astore_2
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: aload 4
    //   255: invokeinterface 402 1 0
    //   260: sipush 26011
    //   263: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: ldc_w 354
    //   272: astore_2
    //   273: goto -107 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   82	2	1	bool	boolean
    //   92	181	2	localObject	Object
    //   94	154	3	str	String
    //   60	194	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   95	105	165	java/lang/Exception
    //   107	125	165	java/lang/Exception
    //   127	152	165	java/lang/Exception
    //   154	162	165	java/lang/Exception
    //   75	83	252	finally
    //   95	105	252	finally
    //   107	125	252	finally
    //   127	152	252	finally
    //   154	162	252	finally
    //   166	196	252	finally
    //   75	83	268	java/lang/Exception
  }
  
  private void fSs()
  {
    int i = 0;
    AppMethodBeat.i(26009);
    ArrayList localArrayList = new ArrayList();
    if ((this.JQn != null) && (this.JQn.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.JQn.moveToFirst()) || (this.JQn.isAfterLast())) {
            break label224;
          }
          i += 1;
          str = this.JQn.getString(this.JQn.getColumnIndex("data1"));
          j = this.JQn.getInt(this.JQn.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.JQn.getCount()) {
              continue;
            }
            w(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          Log.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          w(str, j, true);
          continue;
        }
        finally
        {
          this.JQn.close();
          AppMethodBeat.o(26009);
        }
        this.JQn.moveToNext();
      }
      label224:
      this.JQn.close();
      AppMethodBeat.o(26009);
      return;
    }
    this.JQc.setVisibility(8);
    AppMethodBeat.o(26009);
  }
  
  private void fSt()
  {
    AppMethodBeat.i(26012);
    this.JQj.setOnClickListener(new IPCallUserProfileUI.9(this));
    AppMethodBeat.o(26012);
  }
  
  private void fSu()
  {
    AppMethodBeat.i(26013);
    if (!this.JQo)
    {
      this.JQd.setVisibility(8);
      this.JQh.setVisibility(8);
    }
    Cursor localCursor;
    if (!Util.isNullOrNil(this.idl))
    {
      localCursor = m.aJc(this.idl);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = 0;
          j = i;
          if (!localCursor.isAfterLast())
          {
            k localk = new k();
            localk.convertFrom(localCursor);
            i += 1;
            if (i < 3) {
              break label287;
            }
            bool = true;
            a(localk, bool, localCursor.getCount());
            j = i;
            if (!bool)
            {
              localCursor.moveToNext();
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        Log.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        localCursor = com.tencent.mm.plugin.ipcall.model.h.fRx().aJa(this.iaX);
        break;
        if (j <= 0)
        {
          this.JQd.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        fSv();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(26013);
      }
      label262:
      this.JQd.setVisibility(8);
      this.JQh.setVisibility(8);
      AppMethodBeat.o(26013);
      return;
      label287:
      boolean bool = false;
    }
  }
  
  private void fSv()
  {
    AppMethodBeat.i(26015);
    View localView = LayoutInflater.from(this).inflate(R.i.gnm, this.JQd, false);
    this.JQd.addView(localView);
    localView.setOnClickListener(new IPCallUserProfileUI.3(this));
    AppMethodBeat.o(26015);
  }
  
  private void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26010);
    View localView = LayoutInflater.from(this).inflate(R.i.gnj, this.JQc, false);
    Object localObject = (LinearLayout)localView.findViewById(R.h.fMX);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(R.h.fTk);
      TextView localTextView = (TextView)localView.findViewById(R.h.fTj);
      localTextView.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.a.a.Zu(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new IPCallUserProfileUI.4(this, paramString));
      localView.setOnLongClickListener(new IPCallUserProfileUI.5(this, localTextView));
      this.JQc.addView(localView);
      AppMethodBeat.o(26010);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(R.g.list_item_normal));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkP;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26017);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(26017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26008);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.OAn.b(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new IPCallUserProfileUI.1(this));
    setMMTitle(R.l.gKE);
    this.lKK = ((ImageView)findViewById(R.h.avatar_iv));
    this.JQa = ((TextView)findViewById(R.h.fYB));
    this.JQb = ((TextView)findViewById(R.h.gdv));
    this.JQc = ((LinearLayout)findViewById(R.h.fTy));
    this.JQe = ((TextView)findViewById(R.h.fTx));
    this.JQg = ((TextView)findViewById(R.h.fTw));
    this.JQf = ((TextView)findViewById(R.h.fTv));
    this.JQd = ((LinearLayout)findViewById(R.h.fTA));
    this.JQh = ((TextView)findViewById(R.h.fUE));
    this.JQi = ((TextView)findViewById(R.h.fKJ));
    this.JQj = ((Button)findViewById(R.h.fTu));
    this.idl = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.JQk = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.JQl = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.iaX = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.JQo = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!Util.isNullOrNil(this.idl))
    {
      this.Hom = com.tencent.mm.plugin.ipcall.a.a.br(this, this.idl);
      if (this.Hom != null) {
        this.lKK.setImageBitmap(this.Hom);
      }
    }
    if ((this.Hom == null) && (!Util.isNullOrNil(this.JQl)))
    {
      this.Hom = com.tencent.mm.modelavatar.d.a(this.JQl, false, -1, null);
      if (this.Hom != null) {
        this.lKK.setImageBitmap(this.Hom);
      }
    }
    if (!Util.isNullOrNil(this.JQk))
    {
      this.JQa.setText(this.JQk);
      if ((Util.isNullOrNil(this.JQl)) || (this.JQl.endsWith("@stranger"))) {
        break label541;
      }
      paramBundle = getString(R.l.gKF, new Object[] { aa.getDisplayName(this.JQl) });
      this.JQb.setText(p.b(this, paramBundle));
    }
    label541:
    boolean bool;
    for (;;)
    {
      if (!Util.isNullOrNil(this.idl))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.READ_CONTACTS"))
        {
          Log.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(26008);
          return;
          if (Util.isNullOrNil(this.iaX)) {
            break;
          }
          this.JQa.setText(com.tencent.mm.plugin.ipcall.a.a.aJB(this.iaX));
          break;
          this.JQb.setVisibility(8);
          continue;
        }
        this.JQn = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.idl }, null);
        if (this.JQn.getCount() > 1) {
          break label747;
        }
        bool = true;
        this.JLK = bool;
      }
    }
    fSu();
    this.JQg.setVisibility(8);
    this.JQf.setVisibility(8);
    this.JQe.setVisibility(8);
    this.JQj.setVisibility(8);
    this.JQi.setVisibility(8);
    if ((!Util.isNullOrNil(this.JQl)) && (!Util.isNullOrNil(this.JQk)))
    {
      bh.bCz();
      paramBundle = com.tencent.mm.model.c.bzA().JE(this.JQl);
      if ((paramBundle != null) && (!com.tencent.mm.contact.d.rs(paramBundle.field_type)))
      {
        this.JQj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26003);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            com.tencent.mm.plugin.report.service.h.OAn.b(12766, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.a()
            {
              public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(26001);
                Log.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
                if (paramAnonymous2Boolean1)
                {
                  IPCallUserProfileUI.a(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this, paramAnonymous2String1);
                }
                AppMethodBeat.o(26001);
              }
            });
            localObject = new LinkedList();
            ((LinkedList)localObject).add(Integer.valueOf(86));
            paramAnonymousView.YaM = new a.b()
            {
              public final boolean n(String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
              {
                AppMethodBeat.i(303681);
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(IPCallUserProfileUI.this));
                localIntent.putExtra("Contact_Scene", 13);
                localIntent.putExtra(f.e.adwe, paramAnonymous2String1);
                paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
                int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
                paramAnonymous2String2 = ".ui.SayHiWithSnsPermissionUI";
                if ((!au.bwO(IPCallUserProfileUI.c(IPCallUserProfileUI.this))) && (paramAnonymous2Int == 1)) {
                  paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI2";
                }
                for (;;)
                {
                  com.tencent.mm.br.c.b(IPCallUserProfileUI.this, "profile", paramAnonymous2String1, localIntent);
                  AppMethodBeat.o(303681);
                  return true;
                  paramAnonymous2String1 = paramAnonymous2String2;
                  if (!au.bwO(IPCallUserProfileUI.c(IPCallUserProfileUI.this)))
                  {
                    paramAnonymous2String1 = paramAnonymous2String2;
                    if (paramAnonymous2Int == 2)
                    {
                      paramAnonymous2String1 = paramAnonymous2String2;
                      if (ab.bBW() >= i) {
                        paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI3";
                      }
                    }
                  }
                }
              }
            };
            paramAnonymousView.b(IPCallUserProfileUI.c(IPCallUserProfileUI.this), (LinkedList)localObject, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26003);
          }
        });
        this.JQj.setText(R.l.gKC);
        this.JQj.setVisibility(0);
      }
    }
    for (;;)
    {
      fSs();
      AppMethodBeat.o(26008);
      return;
      label747:
      bool = false;
      break;
      if ((!Util.isNullOrNil(this.idl)) && (!Util.isNullOrNil(this.JQk)))
      {
        fSt();
        this.JQj.setText(R.l.gKD);
      }
      else if (!Util.isNullOrNil(this.iaX))
      {
        this.JQf.setVisibility(0);
        this.JQg.setVisibility(0);
        paramBundle = MMApplicationContext.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (Util.isIntentAvailable(paramBundle, localIntent)) {
          this.JQe.setVisibility(0);
        }
        this.JQe.setOnClickListener(new IPCallUserProfileUI.10(this));
        this.JQf.setOnClickListener(new IPCallUserProfileUI.11(this));
        this.JQg.setOnClickListener(new IPCallUserProfileUI.2(this));
        fSt();
        this.JQj.setText(R.l.gKD);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26016);
    super.onResume();
    if (this.JQm)
    {
      this.JQm = false;
      this.JQd.removeAllViews();
      fSu();
    }
    AppMethodBeat.o(26016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */
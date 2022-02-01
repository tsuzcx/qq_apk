package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.d;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private String ebd;
  private String edf;
  private ImageView gyr;
  private boolean yuw;
  private TextView yyZ;
  private TextView yza;
  private LinearLayout yzb;
  private LinearLayout yzc;
  private TextView yzd;
  private TextView yze;
  private TextView yzf;
  private TextView yzg;
  private TextView yzh;
  private Button yzi;
  private String yzj;
  private String yzk;
  private Bitmap yzl;
  private boolean yzm;
  private Cursor yzn;
  private boolean yzo;
  private e yzp;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(26007);
    this.yuw = false;
    this.yzn = null;
    this.yzo = false;
    this.yzp = new e();
    AppMethodBeat.o(26007);
  }
  
  private void a(k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26014);
    View localView = LayoutInflater.from(this).inflate(2131495988, this.yzc, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131306244);
    TextView localTextView2 = (TextView)localView.findViewById(2131306246);
    TextView localTextView3 = (TextView)localView.findViewById(2131306247);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.GY(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.a.c.GU(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(2131234486));
        int i = getResources().getDimensionPixelSize(2131166822);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.cb.a.aG(getContext(), 2131166792);
        localView.setLayoutParams(paramk);
      }
      this.yzc.addView(localView);
      AppMethodBeat.o(26014);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.Pr(paramk.field_status));
    }
  }
  
  /* Error */
  private static String aCp(String paramString)
  {
    // Byte code:
    //   0: sipush 26011
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 299	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: ldc_w 301
    //   12: invokestatic 307	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +20 -> 35
    //   18: ldc_w 309
    //   21: ldc_w 311
    //   24: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 26011
    //   30: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 299	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   38: invokevirtual 323	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 329	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 331
    //   48: iconst_1
    //   49: anewarray 333	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: aconst_null
    //   57: invokevirtual 339	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnonnull +11 -> 75
    //   67: sipush 26011
    //   70: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload 4
    //   77: invokeinterface 345 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +152 -> 236
    //   87: ldc_w 347
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 350 1 0
    //   102: ifne +138 -> 240
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: aload 4
    //   111: ldc_w 352
    //   114: invokeinterface 356 2 0
    //   119: invokeinterface 359 2 0
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: new 361	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 368
    //   145: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: invokeinterface 375 1 0
    //   161: pop
    //   162: goto -71 -> 91
    //   165: astore_0
    //   166: ldc_w 309
    //   169: ldc_w 377
    //   172: iconst_2
    //   173: anewarray 256	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 380	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: invokevirtual 384	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 389	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 392	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: invokeinterface 395 1 0
    //   203: aload_2
    //   204: astore_0
    //   205: aload_2
    //   206: ldc_w 368
    //   209: invokevirtual 398	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: iflt +16 -> 228
    //   215: aload_2
    //   216: iconst_0
    //   217: aload_2
    //   218: ldc_w 368
    //   221: invokevirtual 398	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_0
    //   228: sipush 26011
    //   231: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: areturn
    //   236: ldc_w 347
    //   239: astore_3
    //   240: aload 4
    //   242: invokeinterface 395 1 0
    //   247: aload_3
    //   248: astore_2
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: aload 4
    //   255: invokeinterface 395 1 0
    //   260: sipush 26011
    //   263: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: ldc_w 347
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
  
  private void ebt()
  {
    int i = 0;
    AppMethodBeat.i(26009);
    ArrayList localArrayList = new ArrayList();
    if ((this.yzn != null) && (this.yzn.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.yzn.moveToFirst()) || (this.yzn.isAfterLast())) {
            break label224;
          }
          i += 1;
          str = this.yzn.getString(this.yzn.getColumnIndex("data1"));
          j = this.yzn.getInt(this.yzn.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.yzn.getCount()) {
              continue;
            }
            q(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          Log.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          q(str, j, true);
          continue;
        }
        finally
        {
          this.yzn.close();
          AppMethodBeat.o(26009);
        }
        this.yzn.moveToNext();
      }
      label224:
      this.yzn.close();
      AppMethodBeat.o(26009);
      return;
    }
    this.yzb.setVisibility(8);
    AppMethodBeat.o(26009);
  }
  
  private void ebu()
  {
    AppMethodBeat.i(26012);
    this.yzi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26004);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).start();
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).yrX = 1L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).yrY = 5L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).finish();
        h.CyF.a(12766, new Object[] { Integer.valueOf(3) });
        if (!Util.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this)))
        {
          localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.aCq(IPCallUserProfileUI.e(IPCallUserProfileUI.this))));
          ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131761898, new Object[] { z.aUL().arI() }));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26004);
          return;
          if (!Util.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this)))
          {
            localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(IPCallUserProfileUI.this)));
            ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131761898, new Object[] { z.aUL().arI() }));
            paramAnonymousView = IPCallUserProfileUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    });
    AppMethodBeat.o(26012);
  }
  
  private void ebv()
  {
    AppMethodBeat.i(26013);
    if (!this.yzo)
    {
      this.yzc.setVisibility(8);
      this.yzg.setVisibility(8);
    }
    Cursor localCursor;
    if (!Util.isNullOrNil(this.edf))
    {
      localCursor = com.tencent.mm.plugin.ipcall.model.h.m.aCb(this.edf);
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
        localCursor = i.eaz().aBZ(this.ebd);
        break;
        if (j <= 0)
        {
          this.yzc.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        ebw();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(26013);
      }
      label262:
      this.yzc.setVisibility(8);
      this.yzg.setVisibility(8);
      AppMethodBeat.o(26013);
      return;
      label287:
      boolean bool = false;
    }
  }
  
  private void ebw()
  {
    AppMethodBeat.i(26015);
    View localView = LayoutInflater.from(this).inflate(2131495989, this.yzc, false);
    this.yzc.addView(localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25996);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
        if (!Util.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this))) {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(IPCallUserProfileUI.this));
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(IPCallUserProfileUI.this));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25996);
          return;
          if (!Util.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this))) {
            ((Intent)localObject).putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
          }
        }
      }
    });
    AppMethodBeat.o(26015);
  }
  
  private void q(final String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26010);
    View localView = LayoutInflater.from(this).inflate(2131495986, this.yzb, false);
    Object localObject = (LinearLayout)localView.findViewById(2131303233);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131305907);
      final TextView localTextView = (TextView)localView.findViewById(2131305906);
      localTextView.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.a.a.Pq(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25997);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25997);
        }
      });
      localView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25998);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, localTextView);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(25998);
          return true;
        }
      });
      this.yzb.addView(localView);
      AppMethodBeat.o(26010);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(2131233327));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495101;
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
    h.CyF.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25994);
        IPCallUserProfileUI.this.finish();
        AppMethodBeat.o(25994);
        return true;
      }
    });
    setMMTitle(2131761917);
    this.gyr = ((ImageView)findViewById(2131297134));
    this.yyZ = ((TextView)findViewById(2131308817));
    this.yza = ((TextView)findViewById(2131310433));
    this.yzb = ((LinearLayout)findViewById(2131306242));
    this.yzd = ((TextView)findViewById(2131306241));
    this.yzf = ((TextView)findViewById(2131306240));
    this.yze = ((TextView)findViewById(2131306239));
    this.yzc = ((LinearLayout)findViewById(2131306245));
    this.yzg = ((TextView)findViewById(2131306742));
    this.yzh = ((TextView)findViewById(2131302717));
    this.yzi = ((Button)findViewById(2131306204));
    this.edf = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.yzj = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.yzk = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.ebd = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.yzo = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!Util.isNullOrNil(this.edf))
    {
      this.yzl = com.tencent.mm.plugin.ipcall.a.a.bd(this, this.edf);
      if (this.yzl != null) {
        this.gyr.setImageBitmap(this.yzl);
      }
    }
    if ((this.yzl == null) && (!Util.isNullOrNil(this.yzk)))
    {
      this.yzl = com.tencent.mm.aj.c.a(this.yzk, false, -1, null);
      if (this.yzl != null) {
        this.gyr.setImageBitmap(this.yzl);
      }
    }
    if (!Util.isNullOrNil(this.yzj))
    {
      this.yyZ.setText(this.yzj);
      if ((Util.isNullOrNil(this.yzk)) || (this.yzk.endsWith("@stranger"))) {
        break label541;
      }
      paramBundle = getString(2131761918, new Object[] { aa.getDisplayName(this.yzk) });
      this.yza.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramBundle));
    }
    label541:
    boolean bool;
    for (;;)
    {
      if (!Util.isNullOrNil(this.edf))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
        {
          Log.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(26008);
          return;
          if (Util.isNullOrNil(this.ebd)) {
            break;
          }
          this.yyZ.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(this.ebd));
          break;
          this.yza.setVisibility(8);
          continue;
        }
        this.yzn = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.edf }, null);
        if (this.yzn.getCount() > 1) {
          break label747;
        }
        bool = true;
        this.yuw = bool;
      }
    }
    ebv();
    this.yzf.setVisibility(8);
    this.yze.setVisibility(8);
    this.yzd.setVisibility(8);
    this.yzi.setVisibility(8);
    this.yzh.setVisibility(8);
    if ((!Util.isNullOrNil(this.yzk)) && (!Util.isNullOrNil(this.yzj)))
    {
      bg.aVF();
      paramBundle = com.tencent.mm.model.c.aSN().Kn(this.yzk);
      if ((paramBundle != null) && (!com.tencent.mm.contact.c.oR(paramBundle.field_type)))
      {
        this.yzi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26003);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            h.CyF.a(12766, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
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
            paramAnonymousView.Kea = new a.b()
            {
              public final boolean aE(String paramAnonymous2String, int paramAnonymous2Int)
              {
                AppMethodBeat.i(26002);
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(IPCallUserProfileUI.this));
                localIntent.putExtra("Contact_Scene", 13);
                localIntent.putExtra(e.d.OyT, paramAnonymous2String);
                paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slQ, 2);
                int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slT, 1000);
                String str = ".ui.SayHiWithSnsPermissionUI";
                if ((!as.bjp(IPCallUserProfileUI.c(IPCallUserProfileUI.this))) && (paramAnonymous2Int == 1)) {
                  paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
                }
                for (;;)
                {
                  com.tencent.mm.br.c.b(IPCallUserProfileUI.this, "profile", paramAnonymous2String, localIntent);
                  AppMethodBeat.o(26002);
                  return true;
                  paramAnonymous2String = str;
                  if (!as.bjp(IPCallUserProfileUI.c(IPCallUserProfileUI.this)))
                  {
                    paramAnonymous2String = str;
                    if (paramAnonymous2Int == 2)
                    {
                      paramAnonymous2String = str;
                      if (ab.aVc() >= i) {
                        paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
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
        this.yzi.setText(2131761910);
        this.yzi.setVisibility(0);
      }
    }
    for (;;)
    {
      ebt();
      AppMethodBeat.o(26008);
      return;
      label747:
      bool = false;
      break;
      if ((!Util.isNullOrNil(this.edf)) && (!Util.isNullOrNil(this.yzj)))
      {
        ebu();
        this.yzi.setText(2131761915);
      }
      else if (!Util.isNullOrNil(this.ebd))
      {
        this.yze.setVisibility(0);
        this.yzf.setVisibility(0);
        paramBundle = MMApplicationContext.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (Util.isIntentAvailable(paramBundle, localIntent)) {
          this.yzd.setVisibility(0);
        }
        this.yzd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26005);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            try
            {
              h.CyF.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
              localObject = new Intent("android.intent.action.INSERT");
              ((Intent)localObject).setType("vnd.android.cursor.dir/contact");
              ((Intent)localObject).putExtra("phone", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
              paramAnonymousView = IPCallUserProfileUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(26005);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                Log.e("MicroMsg.IPCallUserProfileUI", paramAnonymousView.getMessage());
              }
            }
          }
        });
        this.yze.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26006);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26006);
          }
        });
        this.yzf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(25995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            h.CyF.a(12766, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.plugin.ipcall.a.c.aCE(IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            Toast.makeText(IPCallUserProfileUI.this, 2131761909, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25995);
          }
        });
        ebu();
        this.yzi.setText(2131761915);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26016);
    super.onResume();
    if (this.yzm)
    {
      this.yzm = false;
      this.yzc.removeAllViews();
      ebv();
    }
    AppMethodBeat.o(26016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */
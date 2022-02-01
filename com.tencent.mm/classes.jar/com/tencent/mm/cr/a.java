package com.tencent.mm.cr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.c;
import java.util.HashMap;

public final class a
{
  public static a Rzb;
  
  public static void Z(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152898);
    if ((Rzb != null) && (Rzb.bGw()))
    {
      Rzb.r(paramContext, paramString1, paramString2);
      AppMethodBeat.o(152898);
      return;
    }
    paramString2 = bpF(paramString2);
    h.nZ(paramString1, paramString2);
    g.o(paramContext, paramString1, paramString2);
    AppMethodBeat.o(152898);
  }
  
  private static ViewGroup a(MMActivity paramMMActivity, String paramString, ValueCallback<String> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(177308);
    View localView = aa.jQ(paramMMActivity.getContext()).inflate(2131497123, new LinearLayout(paramMMActivity.getContext()), false);
    TextView localTextView1 = (TextView)localView.findViewById(2131310674);
    TextView localTextView2 = (TextView)localView.findViewById(2131310675);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131310676);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131310677);
    ImageButton localImageButton1 = (ImageButton)localView.findViewById(2131310678);
    LinearLayout localLinearLayout3 = (LinearLayout)localView.findViewById(2131310672);
    ImageButton localImageButton2 = (ImageButton)localView.findViewById(2131310671);
    if ((localTextView1 == null) || (localTextView2 == null) || (localLinearLayout1 == null) || (localLinearLayout2 == null) || (localImageButton1 == null) || (localLinearLayout3 == null) || (localImageButton2 == null))
    {
      Log.e("XFilesReaderLogic", "initView can not find view");
      AppMethodBeat.o(177308);
      return null;
    }
    int i = paramMMActivity.getResources().getColor(2131100898);
    if (ao.isDarkMode())
    {
      c(paramMMActivity, i);
      localImageButton1.setImageResource(2131230863);
      localImageButton2.setImageResource(2131230866);
      localLinearLayout2.setVisibility(0);
      localImageButton1.setVisibility(0);
      localImageButton1.setOnClickListener(new a.5(paramValueCallback));
      localLinearLayout3.setVisibility(0);
      if (!paramBoolean) {
        break label438;
      }
      localImageButton2.setVisibility(0);
      localImageButton2.setOnClickListener(new a.6(paramValueCallback));
      label255:
      localLinearLayout1.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(2131768889);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString);
      paramString = new FrameLayout(paramMMActivity);
      paramString.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      if (!ao.isDarkMode()) {
        break label448;
      }
      paramString.setBackgroundColor(-15132391);
    }
    for (;;)
    {
      paramValueCallback = new RelativeLayout(paramMMActivity);
      paramValueCallback.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramValueCallback.setTag("view_tag_relative_layout");
      paramString.addView(paramValueCallback);
      paramValueCallback = new Toolbar(paramMMActivity);
      paramValueCallback.setLayoutParams(new Toolbar.LayoutParams(-1));
      paramValueCallback.setBackgroundColor(i);
      paramValueCallback.mY();
      paramValueCallback.setTag("view_tag_toolbar");
      paramString.addView(paramValueCallback);
      paramMMActivity.setContentView(paramString);
      paramMMActivity.setSupportActionBar(paramValueCallback);
      paramMMActivity = paramMMActivity.getSupportActionBar();
      if (paramMMActivity != null) {
        break label457;
      }
      AppMethodBeat.o(177308);
      return null;
      localImageButton1.setImageResource(2131230855);
      localImageButton2.setImageResource(2131230858);
      break;
      label438:
      localImageButton2.setVisibility(8);
      break label255;
      label448:
      paramString.setBackgroundColor(-3355444);
    }
    label457:
    paramMMActivity.gt();
    paramMMActivity.setDisplayHomeAsUpEnabled(false);
    paramMMActivity.gs();
    paramMMActivity.gu();
    paramMMActivity.setCustomView(localView);
    AppMethodBeat.o(177308);
    return paramString;
  }
  
  static void a(int paramInt, final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, boolean paramBoolean1, boolean paramBoolean2, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1, final boolean paramBoolean3)
  {
    AppMethodBeat.i(223917);
    if (paramBoolean1) {
      f.brZ(paramString3);
    }
    if ((Rzb != null) && (Rzb.bGw()))
    {
      if (Rzb.bGx())
      {
        Log.i("XFilesReaderLogic", "need download miniqb to continue");
        Rzb.bGy();
        AppMethodBeat.o(223917);
        return;
      }
      Log.i("XFilesReaderLogic", "load by mini qb file loader");
      Rzb.d(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new ValueCallback() {});
      AppMethodBeat.o(223917);
      return;
    }
    g.e(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new ValueCallback() {});
    AppMethodBeat.o(223917);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, f.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean)
  {
    AppMethodBeat.i(223916);
    a(paramContext, paramString1, paramString2, paramString3, paramString4, false, new HashMap(), parama, paramValueCallback, paramValueCallback1, paramBoolean);
    AppMethodBeat.o(223916);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, HashMap<String, String> paramHashMap, f.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177306);
    boolean bool;
    String str;
    if (!paramBoolean2)
    {
      bool = true;
      paramHashMap.put("hide_title_bar_right_button", String.valueOf(bool));
      str = bpF(paramString1);
      if (paramString3 == null) {
        break label205;
      }
    }
    label205:
    for (paramString1 = paramString3.toLowerCase();; paramString1 = paramString3)
    {
      d.kT(MMApplicationContext.getContext());
      if (paramBoolean1)
      {
        a(40, paramContext, str, paramString2, paramString1, paramString4, false, true, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
        bool = false;
        break;
      }
      f.nX(str, paramString1);
      paramString3 = new Intent();
      parama = f.a(paramString1, parama, true, paramString3);
      switch (a.8.Rzg[parama.ordinal()])
      {
      default: 
        a(paramString3.getIntExtra(f.SyS, 40), paramContext, str, paramString2, paramString1, paramString4, false, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
      }
      a(paramContext, str, paramString2, paramString1, paramString4, false, com.tencent.xweb.b.hsm(), paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
      AppMethodBeat.o(177306);
      return;
    }
  }
  
  static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean1, boolean paramBoolean2, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, final boolean paramBoolean3)
  {
    AppMethodBeat.i(223918);
    if (paramBoolean1) {
      f.bsb(paramString3);
    }
    if (!(paramContext instanceof MMActivity))
    {
      Log.e("XFilesReaderLogic", "readFileByXWeb not mmactivity, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(223918);
      return;
    }
    MMActivity localMMActivity = (MMActivity)paramContext;
    ViewGroup localViewGroup = a(localMMActivity, paramString2, paramValueCallback, paramBoolean3);
    if (localViewGroup == null)
    {
      Log.e("XFilesReaderLogic", "readFileByXWeb contentView is null, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(223918);
      return;
    }
    h.a(paramString1, paramString3, paramString4, paramBoolean2, h.c.Szq, localMMActivity, localViewGroup, new h.a()new ValueCallback
    {
      public final void Rz(int paramAnonymousInt) {}
      
      public final void ar(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void b(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5) {}
      
      public final void c(int paramAnonymousInt, Bitmap paramAnonymousBitmap) {}
      
      public final void cTA() {}
      
      public final void epu() {}
      
      public final void epv()
      {
        AppMethodBeat.i(223908);
        if (this.lVA != null) {
          this.lVA.onReceiveValue("xwebFileReaderReachEnd");
        }
        AppMethodBeat.o(223908);
      }
      
      public final void epw()
      {
        AppMethodBeat.i(223909);
        if (this.lVA != null) {
          this.lVA.onReceiveValue("xwebFileReaderUserOperated");
        }
        AppMethodBeat.o(223909);
      }
    }, new ValueCallback() {});
    AppMethodBeat.o(223918);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(152904);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("desc_title", paramString2);
    localIntent.putExtra("Retr_Msg_Type", 3);
    c.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(223914);
        if ((paramAnonymousInt1 != 1) || (paramAnonymousInt2 != -1))
        {
          AppMethodBeat.o(223914);
          return;
        }
        if (paramAnonymousIntent == null)
        {
          Log.e("XFilesReaderLogic", "mmOnActivityResult fail, retData is null");
          AppMethodBeat.o(223914);
          return;
        }
        String str = paramAnonymousIntent.getStringExtra("Select_Conv_User");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        if ((str == null) || (str.length() == 0))
        {
          Log.e("XFilesReaderLogic", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(223914);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.setAction("MINIQB_OPEN_RET");
        localIntent.putExtra("op_type", "SEND_TO_FRIENDS");
        localIntent.putExtra("file_path", this.val$filePath);
        localIntent.putExtra("file_name", paramString2);
        localIntent.putExtra("file_ext", paramString3);
        localIntent.putExtra("to_user", str);
        localIntent.putExtra("send_text", paramAnonymousIntent);
        paramMMActivity.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223913);
            com.tencent.mm.ui.widget.snackbar.b.r(a.7.this.val$activity, a.7.this.val$activity.getString(2131768888));
            AppMethodBeat.o(223913);
          }
        });
        AppMethodBeat.o(223914);
      }
    });
    AppMethodBeat.o(152904);
  }
  
  public static String bpF(String paramString)
  {
    AppMethodBeat.i(152899);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("XFilesReaderLogic", "getSafeRealPath filePath is empty");
      AppMethodBeat.o(152899);
      return paramString;
    }
    try
    {
      String str = s.k(paramString, false);
      if (Util.isNullOrNil(str))
      {
        Log.e("XFilesReaderLogic", "getSafeRealPath real path is empty, use old path %s", new Object[] { paramString });
        AppMethodBeat.o(152899);
        return paramString;
      }
      if (str.equals(paramString))
      {
        Log.i("XFilesReaderLogic", "getSafeRealPath real path is the same %s", new Object[] { str });
        AppMethodBeat.o(152899);
        return str;
      }
      Log.i("XFilesReaderLogic", "getSafeRealPath from %s to %s", new Object[] { paramString, str });
      AppMethodBeat.o(152899);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("XFilesReaderLogic", "getSafeRealPath error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152899);
    }
    return paramString;
  }
  
  private static void c(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(177309);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramMMActivity = paramMMActivity.getWindow();
        if (paramMMActivity == null)
        {
          AppMethodBeat.o(177309);
          return;
        }
        paramMMActivity.clearFlags(201326592);
        paramMMActivity.addFlags(-2147483648);
        paramMMActivity.setStatusBarColor(paramInt);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramMMActivity = paramMMActivity.getDecorView();
          paramMMActivity.setSystemUiVisibility(paramMMActivity.getSystemUiVisibility() & 0xFFFFDFFF);
        }
      }
      AppMethodBeat.o(177309);
      return;
    }
    catch (Exception paramMMActivity)
    {
      Log.e("XFilesReaderLogic", "updateStatusBarToDarkMode error ", new Object[] { paramMMActivity });
      AppMethodBeat.o(177309);
    }
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(152903);
    if ((paramContext == null) || (paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("XFilesReaderLogic", "sendResult wrong param");
      AppMethodBeat.o(152903);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("MINIQB_OPEN_RET");
    localIntent.putExtra("op_type", "NOTIFY_RET");
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("MINIQB_OPEN_RET_VAL", bool);
      paramContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(152903);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean bGw();
    
    public abstract boolean bGx();
    
    public abstract void bGy();
    
    public abstract void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1);
    
    public abstract void r(Context paramContext, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cr.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.cr;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import java.util.HashMap;

public final class a
{
  public static a Igy;
  
  public static void T(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152898);
    if ((Igy != null) && (Igy.aZS()))
    {
      Igy.r(paramContext, paramString1, paramString2);
      AppMethodBeat.o(152898);
      return;
    }
    paramString2 = aNq(paramString2);
    h.ma(paramString1, paramString2);
    g.o(paramContext, paramString1, paramString2);
    AppMethodBeat.o(152898);
  }
  
  private static ViewGroup a(MMActivity paramMMActivity, String paramString, ValueCallback<String> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(177308);
    View localView = y.js(paramMMActivity.getContext()).inflate(2131496127, new LinearLayout(paramMMActivity.getContext()), false);
    TextView localTextView1 = (TextView)localView.findViewById(2131307133);
    TextView localTextView2 = (TextView)localView.findViewById(2131307134);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131307135);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131307136);
    ImageButton localImageButton1 = (ImageButton)localView.findViewById(2131307137);
    LinearLayout localLinearLayout3 = (LinearLayout)localView.findViewById(2131307131);
    ImageButton localImageButton2 = (ImageButton)localView.findViewById(2131307130);
    if ((localTextView1 == null) || (localTextView2 == null) || (localLinearLayout1 == null) || (localLinearLayout2 == null) || (localImageButton1 == null) || (localLinearLayout3 == null) || (localImageButton2 == null))
    {
      ad.e("XFilesReaderLogic", "initView can not find view");
      AppMethodBeat.o(177308);
      return null;
    }
    int i = paramMMActivity.getResources().getColor(2131100705);
    if (ai.Eq())
    {
      c(paramMMActivity, i);
      localImageButton1.setImageResource(2131230850);
      localImageButton2.setImageResource(2131230853);
      localLinearLayout2.setVisibility(0);
      localImageButton1.setVisibility(0);
      localImageButton1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(152892);
          this.jQS.onReceiveValue("fileReaderClosed");
          AppMethodBeat.o(152892);
        }
      });
      localLinearLayout3.setVisibility(0);
      if (!paramBoolean) {
        break label432;
      }
      localImageButton2.setVisibility(0);
      localImageButton2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(152893);
          this.jQS.onReceiveValue("fileReaderMenuClicked");
          AppMethodBeat.o(152893);
        }
      });
    }
    for (;;)
    {
      localLinearLayout1.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(2131766372);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString);
      paramString = new FrameLayout(paramMMActivity);
      paramString.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      paramString.setBackgroundColor(-7829368);
      paramValueCallback = new RelativeLayout(paramMMActivity);
      paramValueCallback.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramValueCallback.setTag("view_tag_relative_layout");
      paramString.addView(paramValueCallback);
      paramValueCallback = new Toolbar(paramMMActivity);
      paramValueCallback.setLayoutParams(new Toolbar.LayoutParams(-1));
      paramValueCallback.setBackgroundColor(i);
      paramValueCallback.mu();
      paramValueCallback.setTag("view_tag_toolbar");
      paramString.addView(paramValueCallback);
      paramMMActivity.setContentView(paramString);
      paramMMActivity.setSupportActionBar(paramValueCallback);
      paramMMActivity = paramMMActivity.getSupportActionBar();
      if (paramMMActivity != null) {
        break label442;
      }
      AppMethodBeat.o(177308);
      return null;
      localImageButton1.setImageResource(2131230842);
      localImageButton2.setImageResource(2131230845);
      break;
      label432:
      localImageButton2.setVisibility(8);
    }
    label442:
    paramMMActivity.fM();
    paramMMActivity.setDisplayHomeAsUpEnabled(false);
    paramMMActivity.fL();
    paramMMActivity.fN();
    paramMMActivity.setCustomView(localView);
    AppMethodBeat.o(177308);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, f.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean)
  {
    AppMethodBeat.i(190805);
    a(paramContext, paramString1, paramString2, paramString3, paramString4, false, new HashMap(), parama, paramValueCallback, paramValueCallback1, paramBoolean);
    AppMethodBeat.o(190805);
  }
  
  private static void a(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean)
  {
    AppMethodBeat.i(177307);
    ad.i("XFilesReaderLogic", "readFileByXWeb");
    if (!(paramContext instanceof MMActivity))
    {
      ad.e("XFilesReaderLogic", "readFileByXWeb not mmactivity, use x5");
      e(48, paramContext, paramString1, paramString3, paramString4, false, paramHashMap, paramValueCallback, paramValueCallback1);
      AppMethodBeat.o(177307);
      return;
    }
    MMActivity localMMActivity = (MMActivity)paramContext;
    paramString2 = a(localMMActivity, paramString2, paramValueCallback, paramBoolean);
    if (paramString2 == null)
    {
      ad.e("XFilesReaderLogic", "readFileByXWeb contentView is null, use x5");
      e(48, paramContext, paramString1, paramString3, paramString4, false, paramHashMap, paramValueCallback, paramValueCallback1);
      AppMethodBeat.o(177307);
      return;
    }
    h.a(paramString1, paramString3, paramString4, localMMActivity, paramString2, new ValueCallback() {});
    AppMethodBeat.o(177307);
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
      str = aNq(paramString1);
      if (paramString3 == null) {
        break label193;
      }
    }
    label193:
    for (paramString1 = paramString3.toLowerCase();; paramString1 = paramString3)
    {
      d.ks(aj.getContext());
      if (paramBoolean1)
      {
        e(40, paramContext, str, paramString1, paramString4, true, paramHashMap, paramValueCallback, paramValueCallback1);
        AppMethodBeat.o(177306);
        return;
        bool = false;
        break;
      }
      f.lY(str, paramString1);
      paramString3 = new Intent();
      parama = f.a(paramString1, parama, true, paramString3);
      switch (5.IgA[parama.ordinal()])
      {
      default: 
        e(paramString3.getIntExtra(f.IMs, 40), paramContext, str, paramString1, paramString4, false, paramHashMap, paramValueCallback, paramValueCallback1);
        AppMethodBeat.o(177306);
        return;
      }
      a(paramContext, str, paramString2, paramString1, paramString4, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
      AppMethodBeat.o(177306);
      return;
    }
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
    com.tencent.mm.bs.d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(152895);
        if ((paramAnonymousInt1 != 1) || (paramAnonymousInt2 != -1))
        {
          AppMethodBeat.o(152895);
          return;
        }
        if (paramAnonymousIntent == null)
        {
          ad.e("XFilesReaderLogic", "mmOnActivityResult fail, retData is null");
          AppMethodBeat.o(152895);
          return;
        }
        String str = paramAnonymousIntent.getStringExtra("Select_Conv_User");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        if ((str == null) || (str.length() == 0))
        {
          ad.e("XFilesReaderLogic", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(152895);
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
        paramMMActivity.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(152894);
            b.n(a.4.this.val$activity, a.4.this.val$activity.getString(2131766371));
            AppMethodBeat.o(152894);
          }
        });
        AppMethodBeat.o(152895);
      }
    });
    AppMethodBeat.o(152904);
  }
  
  public static String aNq(String paramString)
  {
    AppMethodBeat.i(152899);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("XFilesReaderLogic", "getSafeRealPath filePath is empty");
      AppMethodBeat.o(152899);
      return paramString;
    }
    try
    {
      String str = i.k(paramString, false);
      if (bt.isNullOrNil(str))
      {
        ad.e("XFilesReaderLogic", "getSafeRealPath real path is empty, use old path %s", new Object[] { paramString });
        AppMethodBeat.o(152899);
        return paramString;
      }
      if (str.equals(paramString))
      {
        ad.i("XFilesReaderLogic", "getSafeRealPath real path is the same %s", new Object[] { str });
        AppMethodBeat.o(152899);
        return str;
      }
      ad.i("XFilesReaderLogic", "getSafeRealPath from %s to %s", new Object[] { paramString, str });
      AppMethodBeat.o(152899);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("XFilesReaderLogic", "getSafeRealPath error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152899);
    }
    return paramString;
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(152903);
    if ((paramContext == null) || (paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      ad.e("XFilesReaderLogic", "sendResult wrong param");
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
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(152903);
      return;
    }
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
      ad.e("XFilesReaderLogic", "updateStatusBarToDarkMode error ", new Object[] { paramMMActivity });
      AppMethodBeat.o(177309);
    }
  }
  
  static void e(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(152900);
    if ((Igy != null) && (Igy.aZS()))
    {
      if (Igy.aZT())
      {
        ad.i("XFilesReaderLogic", "need download miniqb to continue");
        Igy.aZU();
        AppMethodBeat.o(152900);
        return;
      }
      ad.i("XFilesReaderLogic", "load by mini qb file loader");
      Igy.d(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
      AppMethodBeat.o(152900);
      return;
    }
    g.f(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(152900);
  }
  
  public static abstract interface a
  {
    public abstract boolean aZS();
    
    public abstract boolean aZT();
    
    public abstract void aZU();
    
    public abstract void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1);
    
    public abstract void r(Context paramContext, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cr.a
 * JD-Core Version:    0.7.0.1
 */
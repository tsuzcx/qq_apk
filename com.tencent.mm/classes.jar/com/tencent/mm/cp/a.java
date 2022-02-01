package com.tencent.mm.cp;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import java.util.HashMap;

public final class a
{
  public static a LYJ;
  
  public static void V(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152898);
    if ((LYJ != null) && (LYJ.bkZ()))
    {
      LYJ.s(paramContext, paramString1, paramString2);
      AppMethodBeat.o(152898);
      return;
    }
    paramString2 = baw(paramString2);
    h.nf(paramString1, paramString2);
    g.p(paramContext, paramString1, paramString2);
    AppMethodBeat.o(152898);
  }
  
  private static ViewGroup a(MMActivity paramMMActivity, String paramString, ValueCallback<String> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(177308);
    View localView = z.jV(paramMMActivity.getContext()).inflate(2131496127, new LinearLayout(paramMMActivity.getContext()), false);
    TextView localTextView1 = (TextView)localView.findViewById(2131307133);
    TextView localTextView2 = (TextView)localView.findViewById(2131307134);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131307135);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131307136);
    ImageButton localImageButton1 = (ImageButton)localView.findViewById(2131307137);
    LinearLayout localLinearLayout3 = (LinearLayout)localView.findViewById(2131307131);
    ImageButton localImageButton2 = (ImageButton)localView.findViewById(2131307130);
    if ((localTextView1 == null) || (localTextView2 == null) || (localLinearLayout1 == null) || (localLinearLayout2 == null) || (localImageButton1 == null) || (localLinearLayout3 == null) || (localImageButton2 == null))
    {
      ae.e("XFilesReaderLogic", "initView can not find view");
      AppMethodBeat.o(177308);
      return null;
    }
    int i = paramMMActivity.getResources().getColor(2131100705);
    if (al.isDarkMode())
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
          AppMethodBeat.i(218943);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/xwebutil/FileReaderLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.kQw.onReceiveValue("fileReaderClosed");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218943);
        }
      });
      localLinearLayout3.setVisibility(0);
      if (!paramBoolean) {
        break label438;
      }
      localImageButton2.setVisibility(0);
      localImageButton2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(218944);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.kQw.onReceiveValue("fileReaderMenuClicked");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218944);
        }
      });
      label255:
      localLinearLayout1.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(2131766372);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString);
      paramString = new FrameLayout(paramMMActivity);
      paramString.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      if (!al.isDarkMode()) {
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
      paramValueCallback.mW();
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
      localImageButton1.setImageResource(2131230842);
      localImageButton2.setImageResource(2131230845);
      break;
      label438:
      localImageButton2.setVisibility(8);
      break label255;
      label448:
      paramString.setBackgroundColor(-3355444);
    }
    label457:
    paramMMActivity.gm();
    paramMMActivity.setDisplayHomeAsUpEnabled(false);
    paramMMActivity.gl();
    paramMMActivity.gn();
    paramMMActivity.setCustomView(localView);
    AppMethodBeat.o(177308);
    return paramString;
  }
  
  static void a(int paramInt, final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, boolean paramBoolean1, boolean paramBoolean2, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1, final boolean paramBoolean3)
  {
    AppMethodBeat.i(218949);
    if (paramBoolean1) {
      f.bcr(paramString3);
    }
    if ((LYJ != null) && (LYJ.bkZ()))
    {
      if (LYJ.bla())
      {
        ae.i("XFilesReaderLogic", "need download miniqb to continue");
        LYJ.blb();
        AppMethodBeat.o(218949);
        return;
      }
      ae.i("XFilesReaderLogic", "load by mini qb file loader");
      LYJ.d(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new ValueCallback() {});
      AppMethodBeat.o(218949);
      return;
    }
    g.e(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new ValueCallback() {});
    AppMethodBeat.o(218949);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, f.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean)
  {
    AppMethodBeat.i(218948);
    a(paramContext, paramString1, paramString2, paramString3, paramString4, false, new HashMap(), parama, paramValueCallback, paramValueCallback1, paramBoolean);
    AppMethodBeat.o(218948);
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
      str = baw(paramString1);
      if (paramString3 == null) {
        break label205;
      }
    }
    label205:
    for (paramString1 = paramString3.toLowerCase();; paramString1 = paramString3)
    {
      d.kX(ak.getContext());
      if (paramBoolean1)
      {
        a(40, paramContext, str, paramString2, paramString1, paramString4, false, true, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
        bool = false;
        break;
      }
      f.nd(str, paramString1);
      paramString3 = new Intent();
      parama = f.a(paramString1, parama, true, paramString3);
      switch (7.LYO[parama.ordinal()])
      {
      default: 
        a(paramString3.getIntExtra(f.MMd, 40), paramContext, str, paramString2, paramString1, paramString4, false, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
      }
      a(paramContext, str, paramString2, paramString1, paramString4, false, com.tencent.xweb.b.geW(), paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
      AppMethodBeat.o(177306);
      return;
    }
  }
  
  static void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean1, boolean paramBoolean2, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, final boolean paramBoolean3)
  {
    AppMethodBeat.i(218950);
    if (paramBoolean1) {
      f.bct(paramString3);
    }
    if (!(paramContext instanceof MMActivity))
    {
      ae.e("XFilesReaderLogic", "readFileByXWeb not mmactivity, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(218950);
      return;
    }
    MMActivity localMMActivity = (MMActivity)paramContext;
    ViewGroup localViewGroup = a(localMMActivity, paramString2, paramValueCallback, paramBoolean3);
    if (localViewGroup == null)
    {
      ae.e("XFilesReaderLogic", "readFileByXWeb contentView is null, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(218950);
      return;
    }
    h.a(paramString1, paramString3, paramString4, paramBoolean2, localMMActivity, localViewGroup, new ValueCallback() {});
    AppMethodBeat.o(218950);
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
    com.tencent.mm.br.d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(218946);
        if ((paramAnonymousInt1 != 1) || (paramAnonymousInt2 != -1))
        {
          AppMethodBeat.o(218946);
          return;
        }
        if (paramAnonymousIntent == null)
        {
          ae.e("XFilesReaderLogic", "mmOnActivityResult fail, retData is null");
          AppMethodBeat.o(218946);
          return;
        }
        String str = paramAnonymousIntent.getStringExtra("Select_Conv_User");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        if ((str == null) || (str.length() == 0))
        {
          ae.e("XFilesReaderLogic", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(218946);
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
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218945);
            com.tencent.mm.ui.widget.snackbar.b.n(a.6.this.val$activity, a.6.this.val$activity.getString(2131766371));
            AppMethodBeat.o(218945);
          }
        });
        AppMethodBeat.o(218946);
      }
    });
    AppMethodBeat.o(152904);
  }
  
  public static String baw(String paramString)
  {
    AppMethodBeat.i(152899);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("XFilesReaderLogic", "getSafeRealPath filePath is empty");
      AppMethodBeat.o(152899);
      return paramString;
    }
    try
    {
      String str = o.k(paramString, false);
      if (bu.isNullOrNil(str))
      {
        ae.e("XFilesReaderLogic", "getSafeRealPath real path is empty, use old path %s", new Object[] { paramString });
        AppMethodBeat.o(152899);
        return paramString;
      }
      if (str.equals(paramString))
      {
        ae.i("XFilesReaderLogic", "getSafeRealPath real path is the same %s", new Object[] { str });
        AppMethodBeat.o(152899);
        return str;
      }
      ae.i("XFilesReaderLogic", "getSafeRealPath from %s to %s", new Object[] { paramString, str });
      AppMethodBeat.o(152899);
      return str;
    }
    catch (Exception localException)
    {
      ae.e("XFilesReaderLogic", "getSafeRealPath error: %s", new Object[] { localException.getMessage() });
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
      ae.e("XFilesReaderLogic", "updateStatusBarToDarkMode error ", new Object[] { paramMMActivity });
      AppMethodBeat.o(177309);
    }
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(152903);
    if ((paramContext == null) || (paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      ae.e("XFilesReaderLogic", "sendResult wrong param");
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
  
  public static abstract interface a
  {
    public abstract boolean bkZ();
    
    public abstract boolean bla();
    
    public abstract void blb();
    
    public abstract void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1);
    
    public abstract void s(Context paramContext, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cp.a
 * JD-Core Version:    0.7.0.1
 */
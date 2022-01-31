package com.tencent.mm.cn;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.support.v7.widget.ap;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.w;
import com.tencent.xweb.d.a;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class a
{
  private static Map<String, Integer> AZB;
  
  static
  {
    AppMethodBeat.i(151655);
    AZB = new HashMap();
    AppMethodBeat.o(151655);
  }
  
  public static void M(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151650);
    f.iZ(paramString1, paramString2);
    Integer localInteger = (Integer)AZB.get(paramString1 + paramString2);
    if (localInteger != null)
    {
      AZB.remove(paramString1 + paramString2);
      int i = localInteger.intValue();
      Log.i("FileReaderX5", "finishReadFile");
      if (i == 0) {}
      try
      {
        com.tencent.xweb.x5.sdk.d.closeFileReader(paramContext);
        AppMethodBeat.o(151650);
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("FileReaderX5", "finishReadFile error: " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(151650);
  }
  
  private static void a(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(151651);
    e.b(paramInt, paramContext, paramString1, paramString2, paramString3, paramValueCallback, new a.1(paramString3, paramString1, paramValueCallback1));
    AppMethodBeat.o(151651);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, d.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(151649);
    if (paramString3 != null) {
      paramString3 = paramString3.toLowerCase();
    }
    for (;;)
    {
      d.iO(ah.getContext());
      com.tencent.xweb.d.iX(paramString1, paramString3);
      Object localObject1 = new Intent();
      parama = com.tencent.xweb.d.a(paramString3, parama, true, (Intent)localObject1);
      switch (a.6.AZG[parama.ordinal()])
      {
      default: 
        a(((Intent)localObject1).getIntExtra(com.tencent.xweb.d.BCZ, 40), paramContext, paramString1, paramString3, paramString4, paramValueCallback, paramValueCallback1);
        AppMethodBeat.o(151649);
        return;
      }
      ab.i("FileReaderLogic", "readFileByXWeb");
      if (!(paramContext instanceof MMActivity))
      {
        ab.e("FileReaderLogic", "readFileByXWeb not mmactivity, use x5");
        a(48, paramContext, paramString1, paramString3, paramString4, paramValueCallback, paramValueCallback1);
        AppMethodBeat.o(151649);
        return;
      }
      parama = (MMActivity)paramContext;
      localObject1 = w.hM(parama.getContext()).inflate(2130971344, new LinearLayout(parama.getContext()), false);
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131829617);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131829618);
      LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject1).findViewById(2131829615);
      LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject1).findViewById(2131829613);
      ImageButton localImageButton1 = (ImageButton)((View)localObject1).findViewById(2131829614);
      LinearLayout localLinearLayout3 = (LinearLayout)((View)localObject1).findViewById(2131829616);
      ImageButton localImageButton2 = (ImageButton)((View)localObject1).findViewById(2131829619);
      if ((localObject2 == null) || (localTextView == null) || (localLinearLayout1 == null) || (localLinearLayout2 == null) || (localImageButton1 == null) || (localLinearLayout3 == null) || (localImageButton2 == null))
      {
        ab.e("FileReaderLogic", "initView can not find view");
        paramString2 = null;
      }
      while (paramString2 == null)
      {
        ab.e("FileReaderLogic", "readFileByXWeb contentView is null, use x5");
        a(48, paramContext, paramString1, paramString3, paramString4, paramValueCallback, paramValueCallback1);
        AppMethodBeat.o(151649);
        return;
        localLinearLayout2.setVisibility(0);
        localImageButton1.setVisibility(0);
        localImageButton1.setOnClickListener(new a.3(paramValueCallback));
        localLinearLayout3.setVisibility(0);
        localImageButton2.setVisibility(0);
        localImageButton2.setOnClickListener(new a.4(paramValueCallback));
        localLinearLayout1.setVisibility(0);
        localTextView.setVisibility(0);
        localTextView.setText(2131306091);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramString2);
        paramString2 = new FrameLayout(parama);
        paramString2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        paramString2.setBackgroundColor(-7829368);
        localObject2 = new RelativeLayout(parama);
        ((RelativeLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ((RelativeLayout)localObject2).setTag("view_tag_relative_layout");
        paramString2.addView((View)localObject2);
        localObject2 = new Toolbar(parama);
        ((Toolbar)localObject2).setLayoutParams(new Toolbar.LayoutParams(-1));
        ((Toolbar)localObject2).setBackgroundColor(parama.getResources().getColor(2131690316));
        ((Toolbar)localObject2).kS();
        ((Toolbar)localObject2).aoF.aF(0, 0);
        ((Toolbar)localObject2).setTag("view_tag_toolbar");
        paramString2.addView((View)localObject2);
        parama.setContentView(paramString2);
        parama.setSupportActionBar((Toolbar)localObject2);
        localObject2 = parama.getSupportActionBar();
        if (localObject2 == null)
        {
          paramString2 = null;
        }
        else
        {
          ((ActionBar)localObject2).eu();
          ((ActionBar)localObject2).setDisplayHomeAsUpEnabled(false);
          ((ActionBar)localObject2).et();
          ((ActionBar)localObject2).ev();
          ((ActionBar)localObject2).setCustomView((View)localObject1);
        }
      }
      f.a(paramString1, paramString3, paramString4, parama, paramString2, new a.2(paramValueCallback1, paramContext, paramString1, paramString3, paramString4, paramValueCallback));
      AppMethodBeat.o(151649);
      return;
    }
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(151653);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("desc_title", paramString2);
    localIntent.putExtra("Retr_Msg_Type", 3);
    com.tencent.mm.bq.d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(151647);
        if ((paramAnonymousInt1 != 1) || (paramAnonymousInt2 != -1))
        {
          AppMethodBeat.o(151647);
          return;
        }
        if (paramAnonymousIntent == null)
        {
          ab.e("FileReaderLogic", "mmOnActivityResult fail, retData is null");
          AppMethodBeat.o(151647);
          return;
        }
        String str = paramAnonymousIntent.getStringExtra("Select_Conv_User");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        if ((str == null) || (str.length() == 0))
        {
          ab.e("FileReaderLogic", "mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(151647);
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
        al.d(new a.5.1(this));
        AppMethodBeat.o(151647);
      }
    });
    AppMethodBeat.o(151653);
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(151652);
    if ((paramContext == null) || (paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      ab.e("FileReaderLogic", "sendResult wrong param");
      AppMethodBeat.o(151652);
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
      AppMethodBeat.o(151652);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cn.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

public final class d
{
  private static c a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(88842);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == 2130968998)
    {
      localTextView = (TextView)localView.findViewById(2131822379);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(2131297892);
      }
      localTextView.setText(paramContext.getResources().getString(2131297865, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = h.a(paramContext, paramString1, paramString3, localView, paramOnClickListener);
      AppMethodBeat.o(88842);
      return paramContext;
      if (paramInt == 2130968997)
      {
        localTextView = (TextView)localView.findViewById(2131822379);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(2131297892);
        }
        localTextView.setText(paramContext.getResources().getString(2131297864, new Object[] { str }));
      }
    }
  }
  
  private static c a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(88843);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == 2130968998)
    {
      localTextView = (TextView)localView.findViewById(2131822379);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(2131297892);
      }
      localTextView.setText(paramContext.getResources().getString(2131297865, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = h.a(paramContext, paramString1, localView, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(88843);
      return paramContext;
      if (paramInt == 2130968997)
      {
        localTextView = (TextView)localView.findViewById(2131822379);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(2131297892);
        }
        localTextView.setText(paramContext.getResources().getString(2131297864, new Object[] { str }));
      }
    }
  }
  
  public static void a(MMActivity paramMMActivity, d.b paramb)
  {
    AppMethodBeat.i(88836);
    h.a(paramMMActivity, true, paramMMActivity.getString(2131297877), "", paramMMActivity.getString(2131297018), paramMMActivity.getString(2131296888), new d.4(paramb), new d.5());
    AppMethodBeat.o(88836);
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2, d.b paramb)
  {
    AppMethodBeat.i(88835);
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramMMActivity.getString(2131296902);
    }
    for (;;)
    {
      h.a(paramMMActivity, true, paramString2, paramMMActivity.getString(2131297087), paramMMActivity.getString(2131297018), paramMMActivity.getString(2131296888), new d.1(paramb, paramString1), new d.3());
      AppMethodBeat.o(88835);
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88839);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(2131298085);
    }
    h.a(paramMMActivity, str, null, false, new d.6(paramBoolean, paramMMActivity));
    AppMethodBeat.o(88839);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(88838);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "errcode = ".concat(String.valueOf(paramInt));
    }
    a(paramMMActivity, str, false);
    AppMethodBeat.o(88838);
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88841);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(88841);
      return;
    }
    if (paramInt1 == 2130968999) {}
    for (paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(2131297952), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(88833);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(88833);
          }
        });; paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(2131297968), paramContext.getResources().getString(2131297952), new d.10(paramContext), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(88827);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(88827);
          }
        }))
    {
      if (paramContext != null) {
        paramContext.show();
      }
      AppMethodBeat.o(88841);
      return;
    }
  }
  
  public static void c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(88840);
    h.a(paramMMActivity, paramMMActivity.getString(2131298015, new Object[] { paramMMActivity.getString(2131297868) }), paramMMActivity.getString(2131297087), new d.7(paramMMActivity), new d.8());
    AppMethodBeat.o(88840);
  }
  
  public static void c(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(88837);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(2131298085);
    }
    a(paramMMActivity, str, false);
    AppMethodBeat.o(88837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d
 * JD-Core Version:    0.7.0.1
 */
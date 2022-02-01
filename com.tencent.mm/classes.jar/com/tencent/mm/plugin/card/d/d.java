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

public final class d
{
  private static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113770);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == 2131493349)
    {
      localTextView = (TextView)localView.findViewById(2131297897);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(2131756824);
      }
      localTextView.setText(paramContext.getResources().getString(2131756797, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = h.a(paramContext, paramString1, paramString3, localView, paramOnClickListener);
      AppMethodBeat.o(113770);
      return paramContext;
      if (paramInt == 2131493348)
      {
        localTextView = (TextView)localView.findViewById(2131297897);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(2131756824);
        }
        localTextView.setText(paramContext.getResources().getString(2131756796, new Object[] { str }));
      }
    }
  }
  
  private static com.tencent.mm.ui.widget.a.d a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(113771);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == 2131493349)
    {
      localTextView = (TextView)localView.findViewById(2131297897);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(2131756824);
      }
      localTextView.setText(paramContext.getResources().getString(2131756797, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = h.a(paramContext, paramString1, localView, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(113771);
      return paramContext;
      if (paramInt == 2131493348)
      {
        localTextView = (TextView)localView.findViewById(2131297897);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(2131756824);
        }
        localTextView.setText(paramContext.getResources().getString(2131756796, new Object[] { str }));
      }
    }
  }
  
  public static void a(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(113764);
    h.a(paramMMActivity, true, paramMMActivity.getString(2131756809), "", paramMMActivity.getString(2131755835), paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113757);
        paramAnonymousDialogInterface.dismiss();
        this.oWd.bYm();
        AppMethodBeat.o(113757);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113758);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(113758);
      }
    });
    AppMethodBeat.o(113764);
  }
  
  public static void a(MMActivity paramMMActivity, final String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(113763);
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramMMActivity.getString(2131755709);
    }
    for (;;)
    {
      h.a(paramMMActivity, true, paramString2, paramMMActivity.getString(2131755906), paramMMActivity.getString(2131755835), paramMMActivity.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113754);
          paramAnonymousDialogInterface.dismiss();
          this.oWd.bUG();
          AppMethodBeat.o(113754);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113756);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(113756);
        }
      });
      AppMethodBeat.o(113763);
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(113767);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(2131757027);
    }
    h.a(paramMMActivity, str, null, false, new d.6(paramBoolean, paramMMActivity));
    AppMethodBeat.o(113767);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(113766);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "errcode = ".concat(String.valueOf(paramInt));
    }
    a(paramMMActivity, str, false);
    AppMethodBeat.o(113766);
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(113769);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(113769);
      return;
    }
    if (paramInt1 == 2131493350) {}
    for (paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(2131756894), new d.9());; paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(2131756910), paramContext.getResources().getString(2131756894), new d.10(paramContext), new d.2()))
    {
      if (paramContext != null) {
        paramContext.show();
      }
      AppMethodBeat.o(113769);
      return;
    }
  }
  
  public static void c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113768);
    h.a(paramMMActivity, paramMMActivity.getString(2131756957, new Object[] { paramMMActivity.getString(2131756800) }), paramMMActivity.getString(2131755906), new d.7(paramMMActivity), new d.8());
    AppMethodBeat.o(113768);
  }
  
  public static void c(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(113765);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(2131757027);
    }
    a(paramMMActivity, str, false);
    AppMethodBeat.o(113765);
  }
  
  public static class a
    implements d.b
  {
    public void bUG() {}
    
    public void bYm() {}
  }
  
  public static abstract interface b
  {
    public abstract void bUG();
    
    public abstract void bYm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d
 * JD-Core Version:    0.7.0.1
 */
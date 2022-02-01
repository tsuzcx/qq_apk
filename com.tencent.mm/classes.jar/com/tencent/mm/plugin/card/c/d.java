package com.tencent.mm.plugin.card.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class d
{
  private static e a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113770);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == a.e.wnG)
    {
      localTextView = (TextView)localView.findViewById(a.d.whK);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(a.g.wou);
      }
      localTextView.setText(paramContext.getResources().getString(a.g.wob, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = k.a(paramContext, paramString1, paramString3, localView, paramOnClickListener);
      AppMethodBeat.o(113770);
      return paramContext;
      if (paramInt == a.e.wnF)
      {
        localTextView = (TextView)localView.findViewById(a.d.whK);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(a.g.wou);
        }
        localTextView.setText(paramContext.getResources().getString(a.g.woa, new Object[] { str }));
      }
    }
  }
  
  private static e a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(113771);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    TextView localTextView;
    String str;
    if (paramInt == a.e.wnG)
    {
      localTextView = (TextView)localView.findViewById(a.d.whK);
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramContext.getResources().getString(a.g.wou);
      }
      localTextView.setText(paramContext.getResources().getString(a.g.wob, new Object[] { str }));
    }
    for (;;)
    {
      paramContext = k.a(paramContext, paramString1, localView, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
      AppMethodBeat.o(113771);
      return paramContext;
      if (paramInt == a.e.wnF)
      {
        localTextView = (TextView)localView.findViewById(a.d.whK);
        str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = paramContext.getResources().getString(a.g.wou);
        }
        localTextView.setText(paramContext.getResources().getString(a.g.woa, new Object[] { str }));
      }
    }
  }
  
  public static void a(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(113764);
    k.a(paramMMActivity, true, paramMMActivity.getString(a.g.wok), "", paramMMActivity.getString(a.g.app_ok), paramMMActivity.getString(a.g.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113757);
        paramAnonymousDialogInterface.dismiss();
        d.this.nP();
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
      paramString2 = paramMMActivity.getString(a.g.app_delete_tips);
    }
    for (;;)
    {
      k.a(paramMMActivity, true, paramString2, paramMMActivity.getString(a.g.app_tip), paramMMActivity.getString(a.g.app_ok), paramMMActivity.getString(a.g.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113754);
          paramAnonymousDialogInterface.dismiss();
          d.this.djn();
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
      str = paramMMActivity.getString(a.g.wqJ);
    }
    k.a(paramMMActivity, str, null, false, new d.6(paramBoolean, paramMMActivity));
    AppMethodBeat.o(113767);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(113765);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(a.g.wqJ);
    }
    a(paramMMActivity, str, false);
    AppMethodBeat.o(113765);
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
    if (paramInt1 == a.e.wnH) {}
    for (paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(a.g.woZ), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113761);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(113761);
          }
        });; paramContext = a(paramContext, paramInt1, paramContext.getResources().getString(paramInt2), paramString, paramContext.getResources().getString(a.g.wph), paramContext.getResources().getString(a.g.woZ), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113762);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = new mg();
            paramAnonymousDialogInterface.hOp.context = d.this;
            paramAnonymousDialogInterface.publish();
            Log.i("MicroMsg.CardDialogHelper", "enter to cardhome");
            AppMethodBeat.o(113762);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113755);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(113755);
          }
        }))
    {
      if (paramContext != null) {
        paramContext.show();
      }
      AppMethodBeat.o(113769);
      return;
    }
  }
  
  public static void e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113768);
    k.a(paramMMActivity, paramMMActivity.getString(a.g.wpM, new Object[] { paramMMActivity.getString(a.g.woe) }), paramMMActivity.getString(a.g.app_tip), new d.7(paramMMActivity), new d.8());
    AppMethodBeat.o(113768);
  }
  
  public static abstract interface b
  {
    public abstract void djn();
    
    public abstract void nP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.d
 * JD-Core Version:    0.7.0.1
 */
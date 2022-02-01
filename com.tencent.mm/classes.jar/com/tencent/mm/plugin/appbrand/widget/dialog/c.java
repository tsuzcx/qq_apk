package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends b
{
  private final String kyo;
  private final String mAppName;
  private Context mContext;
  private AuthorizeItemListView naX;
  private LinearLayout naZ;
  private c.b ncM;
  
  public c(final Context paramContext, List<c.c> paramList, String paramString1, String paramString2, final a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(192327);
    this.mContext = paramContext;
    this.mAppName = bt.nullAsNil(paramString1);
    this.kyo = paramString2;
    if ((paramList instanceof ArrayList)) {}
    for (paramContext = (ArrayList)paramList; (paramContext == null) || (paramContext.size() <= 0); paramContext = new ArrayList(paramList))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(192327);
      throw paramContext;
    }
    paramList = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131492972, null);
    setContentView(paramList);
    paramString1 = (ImageView)paramList.findViewById(2131296853);
    com.tencent.mm.modelappbrand.a.b.aDV().a(paramString1, this.kyo, 2131233241, g.hLC);
    ((TextView)paramList.findViewById(2131296866)).setText(this.mContext.getString(2131760748, new Object[] { this.mAppName }));
    this.naX = ((AuthorizeItemListView)paramList.findViewById(2131296973));
    this.ncM = new c.b(paramContext);
    this.naX.setAdapter(this.ncM);
    if (paramContext.size() > 5)
    {
      this.naX.ajO = paramContext.size();
      this.naZ = ((LinearLayout)paramList.findViewById(2131296983));
      paramString1 = (LinearLayout.LayoutParams)this.naZ.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(2131166486);
      this.naZ.setLayoutParams(paramString1);
    }
    ((Button)paramList.findViewById(2131301557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147732);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        ad.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        parama.a(1, paramAnonymousView);
        jdField_this.dismiss();
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(147732);
      }
    });
    ((Button)paramList.findViewById(2131301580)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147733);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < paramContext.size())
        {
          if ((((c.c)paramContext.get(i)).state == 2) || (((c.c)paramContext.get(i)).state == 3)) {
            paramAnonymousView.add(((c.c)paramContext.get(i)).scope);
          }
          i += 1;
        }
        ad.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        parama.a(2, paramAnonymousView);
        jdField_this.dismiss();
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(147733);
      }
    });
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(147734);
        ad.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        parama.a(3, null);
        AppMethodBeat.o(147734);
      }
    });
    AppMethodBeat.o(192327);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ArrayList<String> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */
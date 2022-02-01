package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends b
{
  private b KCz;
  private final String jDl;
  private AuthorizeItemListView lYn;
  private LinearLayout lYp;
  private final String mAppName;
  private Context mContext;
  
  public c(final Context paramContext, List<c> paramList, String paramString1, String paramString2, final a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(186911);
    this.mContext = paramContext;
    this.mAppName = bt.nullAsNil(paramString1);
    this.jDl = paramString2;
    if ((paramList instanceof ArrayList)) {}
    for (paramContext = (ArrayList)paramList; (paramContext == null) || (paramContext.size() <= 0); paramContext = new ArrayList(paramList))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(186911);
      throw paramContext;
    }
    paramList = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2131492972, null);
    setContentView(paramList);
    paramString1 = (ImageView)paramList.findViewById(2131296853);
    com.tencent.mm.modelappbrand.a.b.aub().a(paramString1, this.jDl, 2131233241, g.gSK);
    ((TextView)paramList.findViewById(2131296866)).setText(this.mContext.getString(2131760748, new Object[] { this.mAppName }));
    this.lYn = ((AuthorizeItemListView)paramList.findViewById(2131296973));
    this.KCz = new b(paramContext);
    this.lYn.setAdapter(this.KCz);
    if (paramContext.size() > 5)
    {
      this.lYn.ahd = paramContext.size();
      this.lYp = ((LinearLayout)paramList.findViewById(2131296983));
      paramString1 = (LinearLayout.LayoutParams)this.lYp.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(2131166486);
      this.lYp.setLayoutParams(paramString1);
    }
    ((Button)paramList.findViewById(2131301557)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147732);
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
        AppMethodBeat.o(147732);
      }
    });
    ((Button)paramList.findViewById(2131301580)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(147733);
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
    AppMethodBeat.o(186911);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, ArrayList<String> paramArrayList);
  }
  
  static final class b
    extends BaseAdapter
  {
    private final ArrayList<c.c> KCE;
    
    b(ArrayList<c.c> paramArrayList)
    {
      this.KCE = paramArrayList;
    }
    
    private c.c agM(int paramInt)
    {
      AppMethodBeat.i(147737);
      c.c localc = (c.c)this.KCE.get(paramInt);
      AppMethodBeat.o(147737);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(147736);
      if (this.KCE == null)
      {
        AppMethodBeat.o(147736);
        return 0;
      }
      int i = this.KCE.size();
      AppMethodBeat.o(147736);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(147738);
      if ((this.KCE == null) || (this.KCE.size() <= 0))
      {
        AppMethodBeat.o(147738);
        return null;
      }
      final c.c localc = agM(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localObject = View.inflate(paramViewGroup.getContext(), 2131493120, null);
        paramView.KCI = ((ImageView)((View)localObject).findViewById(2131296682));
        paramView.lYz = ((TextView)((View)localObject).findViewById(2131296681));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if (localc.state != 1) {
          break label173;
        }
        paramViewGroup.KCI.setImageResource(2131232921);
      }
      for (;;)
      {
        paramViewGroup.lYz.setText(localc.desc);
        localObject = paramViewGroup.KCI;
        paramViewGroup.KCI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(147735);
            if (localc.state == 2)
            {
              this.KCG.setImageResource(2131232921);
              localc.state = 1;
              AppMethodBeat.o(147735);
              return;
            }
            if (localc.state == 1)
            {
              this.KCG.setImageResource(2131232919);
              localc.state = 2;
            }
            AppMethodBeat.o(147735);
          }
        });
        AppMethodBeat.o(147738);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label173:
        if (localc.state == 3) {
          paramViewGroup.KCI.setImageResource(2131232920);
        } else {
          paramViewGroup.KCI.setImageResource(2131232919);
        }
      }
    }
    
    static final class a
    {
      ImageView KCI;
      TextView lYz;
    }
  }
  
  public static final class c
  {
    public String desc;
    public String scope;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c
 * JD-Core Version:    0.7.0.1
 */
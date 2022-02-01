package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.r;

public final class a
  extends r<n>
{
  private String jbD;
  a jel;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(110068);
    this.jbD = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(110071);
    this.mFilter = bu.aSk(paramString);
    dhl();
    ZD();
    AppMethodBeat.o(110071);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(110070);
    setCursor(((o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bQ(this.mFilter, this.jbD));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(110069);
    ZD();
    AppMethodBeat.o(110069);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110072);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mLayoutInflater.inflate(2131494408, null);
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
    }
    n localn;
    for (;;)
    {
      localn = (n)getItem(paramInt);
      if (localn != null) {
        break;
      }
      AppMethodBeat.o(110072);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.position = paramInt;
    paramViewGroup.jem = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.fSj.setText(bu.aSL(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.jen.setText(localn.field_googlegmail);
            AppMethodBeat.o(110072);
            return paramView;
          }
          break;
        }
      }
      break;
    case 0: 
    case 2: 
      label146:
      label176:
      label208:
      if (localn.field_small_url == null) {}
      break;
    }
    for (Bitmap localBitmap = c.a(localn.field_username, false, -1, null);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fTj.setImageBitmap(localBitmap);
      break;
      localBitmap = c.Dl(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fTj.setImageBitmap(localBitmap);
      break;
      paramViewGroup.fSj.setText(localn.field_googlename);
      break label146;
      paramViewGroup.jeo.setClickable(true);
      paramViewGroup.jeo.setBackgroundResource(2131231365);
      paramViewGroup.fWX.setText(2131760015);
      paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131101179));
      break label176;
      paramViewGroup.jeo.setClickable(true);
      paramViewGroup.jeo.setBackgroundResource(2131231367);
      paramViewGroup.fWX.setText(2131760023);
      paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.jeo.setClickable(false);
      paramViewGroup.jeo.setBackgroundDrawable(null);
      paramViewGroup.fWX.setText(2131760017);
      paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.fWX.setVisibility(4);
      paramViewGroup.jep.setVisibility(0);
      break label208;
      paramViewGroup.jeo.setClickable(false);
      paramViewGroup.jeo.setBackgroundDrawable(null);
      paramViewGroup.fWX.setVisibility(0);
      paramViewGroup.jep.setVisibility(8);
      paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131100544));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.fWX.setText(2131760016);
        break;
      case 1: 
        paramViewGroup.fWX.setText(2131760024);
        break;
        paramViewGroup.fWX.setVisibility(0);
        paramViewGroup.jep.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.fWX.setText(2131760015);
          paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131101179));
          break;
        case 1: 
          paramViewGroup.fWX.setText(2131760023);
          paramViewGroup.fWX.setTextColor(this.mContext.getResources().getColor(2131100544));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void rn(int paramInt);
  }
  
  final class b
  {
    TextView fSj;
    ImageView fTj;
    TextView fWX;
    String jem;
    TextView jen;
    View jeo;
    ProgressBar jep;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.fTj = ((ImageView)paramView.findViewById(2131300572));
      this.fSj = ((TextView)paramView.findViewById(2131300576));
      this.jeo = paramView.findViewById(2131300577);
      this.fWX = ((TextView)paramView.findViewById(2131300578));
      this.jep = ((ProgressBar)paramView.findViewById(2131300575));
      this.jen = ((TextView)paramView.findViewById(2131300573));
      this.jeo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).rn(a.b.this.position);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/GoogleFriendAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110066);
        }
      });
      AppMethodBeat.o(110067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */
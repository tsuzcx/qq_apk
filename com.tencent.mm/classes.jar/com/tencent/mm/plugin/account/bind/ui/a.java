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
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.q;

public final class a
  extends q<n>
{
  private String ifs;
  a iib;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(110068);
    this.ifs = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(110071);
    this.mFilter = bt.aFQ(paramString);
    cHX();
    Wd();
    AppMethodBeat.o(110071);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(110070);
    setCursor(((o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bG(this.mFilter, this.ifs));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void We()
  {
    AppMethodBeat.i(110069);
    Wd();
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
    paramViewGroup.iic = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.ftj.setText(bt.aGr(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.iid.setText(localn.field_googlegmail);
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
        paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fuj.setImageBitmap(localBitmap);
      break;
      localBitmap = c.vE(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fuj.setImageBitmap(localBitmap);
      break;
      paramViewGroup.ftj.setText(localn.field_googlename);
      break label146;
      paramViewGroup.iie.setClickable(true);
      paramViewGroup.iie.setBackgroundResource(2131231365);
      paramViewGroup.fxX.setText(2131760015);
      paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131101179));
      break label176;
      paramViewGroup.iie.setClickable(true);
      paramViewGroup.iie.setBackgroundResource(2131231367);
      paramViewGroup.fxX.setText(2131760023);
      paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.iie.setClickable(false);
      paramViewGroup.iie.setBackgroundDrawable(null);
      paramViewGroup.fxX.setText(2131760017);
      paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.fxX.setVisibility(4);
      paramViewGroup.iif.setVisibility(0);
      break label208;
      paramViewGroup.iie.setClickable(false);
      paramViewGroup.iie.setBackgroundDrawable(null);
      paramViewGroup.fxX.setVisibility(0);
      paramViewGroup.iif.setVisibility(8);
      paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131100544));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.fxX.setText(2131760016);
        break;
      case 1: 
        paramViewGroup.fxX.setText(2131760024);
        break;
        paramViewGroup.fxX.setVisibility(0);
        paramViewGroup.iif.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.fxX.setText(2131760015);
          paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131101179));
          break;
        case 1: 
          paramViewGroup.fxX.setText(2131760023);
          paramViewGroup.fxX.setTextColor(this.mContext.getResources().getColor(2131100544));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void pX(int paramInt);
  }
  
  final class b
  {
    TextView ftj;
    ImageView fuj;
    TextView fxX;
    String iic;
    TextView iid;
    View iie;
    ProgressBar iif;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.fuj = ((ImageView)paramView.findViewById(2131300572));
      this.ftj = ((TextView)paramView.findViewById(2131300576));
      this.iie = paramView.findViewById(2131300577);
      this.fxX = ((TextView)paramView.findViewById(2131300578));
      this.iif = ((ProgressBar)paramView.findViewById(2131300575));
      this.iid = ((TextView)paramView.findViewById(2131300573));
      this.iie.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          ad.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).pX(a.b.this.position);
          }
          AppMethodBeat.o(110066);
        }
      });
      AppMethodBeat.o(110067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */
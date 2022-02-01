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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.r;

public final class a
  extends r<n>
{
  private String iFB;
  a iIj;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    AppMethodBeat.i(110068);
    this.iFB = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(110068);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(110071);
    this.mFilter = bs.aLh(paramString);
    cVi();
    Xb();
    AppMethodBeat.o(110071);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(110070);
    setCursor(((o)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).bO(this.mFilter, this.iFB));
    super.notifyDataSetChanged();
    AppMethodBeat.o(110070);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(110069);
    Xb();
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
    paramViewGroup.iIk = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.fwQ.setText(bs.aLI(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.iIl.setText(localn.field_googlegmail);
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
        paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fxQ.setImageBitmap(localBitmap);
      break;
      localBitmap = c.zK(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690013));
        break;
      }
      paramViewGroup.fxQ.setImageBitmap(localBitmap);
      break;
      paramViewGroup.fwQ.setText(localn.field_googlename);
      break label146;
      paramViewGroup.iIm.setClickable(true);
      paramViewGroup.iIm.setBackgroundResource(2131231365);
      paramViewGroup.fBE.setText(2131760015);
      paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131101179));
      break label176;
      paramViewGroup.iIm.setClickable(true);
      paramViewGroup.iIm.setBackgroundResource(2131231367);
      paramViewGroup.fBE.setText(2131760023);
      paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.iIm.setClickable(false);
      paramViewGroup.iIm.setBackgroundDrawable(null);
      paramViewGroup.fBE.setText(2131760017);
      paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131100544));
      break label176;
      paramViewGroup.fBE.setVisibility(4);
      paramViewGroup.iIn.setVisibility(0);
      break label208;
      paramViewGroup.iIm.setClickable(false);
      paramViewGroup.iIm.setBackgroundDrawable(null);
      paramViewGroup.fBE.setVisibility(0);
      paramViewGroup.iIn.setVisibility(8);
      paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131100544));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.fBE.setText(2131760016);
        break;
      case 1: 
        paramViewGroup.fBE.setText(2131760024);
        break;
        paramViewGroup.fBE.setVisibility(0);
        paramViewGroup.iIn.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.fBE.setText(2131760015);
          paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131101179));
          break;
        case 1: 
          paramViewGroup.fBE.setText(2131760023);
          paramViewGroup.fBE.setTextColor(this.mContext.getResources().getColor(2131100544));
          break;
        }
        break;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void qK(int paramInt);
  }
  
  final class b
  {
    TextView fBE;
    TextView fwQ;
    ImageView fxQ;
    String iIk;
    TextView iIl;
    View iIm;
    ProgressBar iIn;
    int position;
    
    public b(View paramView)
    {
      AppMethodBeat.i(110067);
      this.fxQ = ((ImageView)paramView.findViewById(2131300572));
      this.fwQ = ((TextView)paramView.findViewById(2131300576));
      this.iIm = paramView.findViewById(2131300577);
      this.fBE = ((TextView)paramView.findViewById(2131300578));
      this.iIn = ((ProgressBar)paramView.findViewById(2131300575));
      this.iIl = ((TextView)paramView.findViewById(2131300573));
      this.iIm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110066);
          ac.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
          if (a.a(a.this) != null) {
            a.a(a.this).qK(a.b.this.position);
          }
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
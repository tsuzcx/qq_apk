package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$d
  extends RecyclerView.v
{
  TextView kFj;
  View.OnLongClickListener mAd;
  ImageView mCA;
  View mCB;
  CheckBox mCC;
  View mCD;
  ImageView mCy;
  View mCz;
  
  public f$d(f paramf, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(74577);
    this.mAd = new f.d.4(this);
    this.mCy = ((ImageView)paramView.findViewById(2131824016));
    this.mCz = paramView.findViewById(2131824020);
    this.mCB = paramView.findViewById(2131824022);
    this.kFj = ((TextView)paramView.findViewById(2131822813));
    this.mCA = ((ImageView)paramView.findViewById(2131824024));
    this.mCC = ((CheckBox)paramView.findViewById(2131824025));
    this.mCD = paramView.findViewById(2131824026);
    this.mCD.setVisibility(8);
    this.mCC.setVisibility(8);
    this.mCz.setVisibility(8);
    this.kFj.setVisibility(8);
    this.mCB.setVisibility(8);
    this.mCy.setOnTouchListener(new f.d.1(this, paramf));
    this.mCy.setOnClickListener(new f.d.2(this, paramf));
    this.mCy.setOnLongClickListener(this.mAd);
    this.mCD.setOnClickListener(new f.d.3(this, paramf));
    AppMethodBeat.o(74577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d
 * JD-Core Version:    0.7.0.1
 */
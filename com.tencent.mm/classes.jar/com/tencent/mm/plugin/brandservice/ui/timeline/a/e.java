package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class e
{
  public ImageView egq;
  public TextView ekh;
  private View.OnClickListener jXE;
  public com.tencent.mm.plugin.brandservice.ui.timeline.a jXV;
  public View jXW;
  public View jXX;
  public TextView jXY;
  public View jXr;
  public Context mContext;
  
  public e()
  {
    AppMethodBeat.i(14250);
    this.jXE = new e.1(this);
    AppMethodBeat.o(14250);
  }
  
  public static void Q(View paramView, int paramInt)
  {
    AppMethodBeat.i(14253);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(14253);
  }
  
  private String dK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152636);
    if ((paramInt1 == 5) || (paramInt1 == 8))
    {
      str = this.mContext.getString(2131297694, new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(152636);
      return str;
    }
    if (paramInt1 == 7)
    {
      str = this.mContext.getString(2131297693, new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(152636);
      return str;
    }
    String str = this.mContext.getString(2131297693, new Object[] { Integer.valueOf(paramInt2) });
    AppMethodBeat.o(152636);
    return str;
  }
  
  public void a(View paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    AppMethodBeat.i(14251);
    b(paramView.getContext(), parama);
    AppMethodBeat.o(14251);
  }
  
  public void a(ImageView paramImageView, com.tencent.mm.storage.q paramq, int paramInt, String paramString)
  {
    AppMethodBeat.i(14256);
    ((com.tencent.mm.plugin.brandservice.a.a)g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramq.field_msgId, paramString, paramq.field_content, paramInt);
    paramImageView.setOnClickListener(this.jXE);
    AppMethodBeat.o(14256);
  }
  
  public void a(com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1)
  {
    AppMethodBeat.i(14255);
    if ((paramq1 == null) || (bo.isNullOrNil(paramq1.url)) || (paramq.field_appMsgStatInfoProto == null) || (bo.es(paramq.field_appMsgStatInfoProto.wqW)))
    {
      paramView.setVisibility(8);
      a(paramq, paramq1, paramView, paramTextView, 0);
      AppMethodBeat.o(14255);
      return false;
    }
    int j = 0;
    Iterator localIterator = paramq.field_appMsgStatInfoProto.wqW.iterator();
    et localet;
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      localet = (et)localIterator.next();
    } while (!bo.isEqual(localet.url, paramq1.url));
    int i = localet.wqV;
    if (i > 0)
    {
      paramView.setVisibility(0);
      paramTextView.setText(dK(paramq1.type, i));
      a(paramq, paramq1, paramView, paramTextView, i);
      AppMethodBeat.o(14255);
      return true;
    }
    paramView.setVisibility(8);
    a(paramq, paramq1, paramView, paramTextView, i);
    AppMethodBeat.o(14255);
    return false;
  }
  
  public final boolean a(c paramc, com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1)
  {
    AppMethodBeat.i(14254);
    boolean bool = a(paramc.jXz, paramc.jXA, paramq, paramq1);
    AppMethodBeat.o(14254);
    return bool;
  }
  
  public void aWX()
  {
    AppMethodBeat.i(14252);
    if (this.jXr == null)
    {
      AppMethodBeat.o(14252);
      return;
    }
    this.egq = ((ImageView)this.jXr.findViewById(2131821210));
    this.jXY = ((TextView)this.jXr.findViewById(2131821854));
    this.ekh = ((TextView)this.jXr.findViewById(2131821004));
    this.jXX = this.jXr.findViewById(2131821853);
    AppMethodBeat.o(14252);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.a parama)
  {
    this.mContext = paramContext;
    this.jXV = parama;
  }
  
  public void dd(View paramView)
  {
    AppMethodBeat.i(152635);
    Q(paramView, com.tencent.mm.plugin.brandservice.ui.timeline.a.jVt);
    AppMethodBeat.o(152635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.e
 * JD-Core Version:    0.7.0.1
 */
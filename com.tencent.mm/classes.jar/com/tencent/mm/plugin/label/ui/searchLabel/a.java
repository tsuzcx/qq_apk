package com.tencent.mm.plugin.label.ui.searchLabel;

import android.content.Context;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.label.ui.e;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends RecyclerView.a<e>
{
  SparseArray<SpannableString> JWe;
  public List<String> JXS;
  public List<String> JXT;
  private List<String> JXU;
  private int JXV;
  ArrayList<aw> JXW;
  View.OnTouchListener JXX;
  a JXY;
  public List<String> JXy;
  private Context mContext;
  ArrayList<aw> mlK;
  String pQF;
  
  a(Context paramContext)
  {
    AppMethodBeat.i(268835);
    this.JXy = new LinkedList();
    this.JXS = new LinkedList();
    this.JXT = new LinkedList();
    this.JXU = new LinkedList();
    this.JXV = 0;
    this.JXW = null;
    this.pQF = "";
    this.JXX = null;
    this.JXY = null;
    this.JWe = new SparseArray();
    this.mContext = paramContext;
    AppMethodBeat.o(268835);
  }
  
  public final void ZA(int paramInt)
  {
    AppMethodBeat.i(268865);
    this.JXV = paramInt;
    if (this.JXy != null) {
      this.JXy.clear();
    }
    this.bZE.notifyChanged();
    AppMethodBeat.o(268865);
  }
  
  public final aw Zz(int paramInt)
  {
    AppMethodBeat.i(268858);
    if ((this.mlK == null) || (paramInt > this.mlK.size()))
    {
      AppMethodBeat.o(268858);
      return null;
    }
    aw localaw = (aw)this.mlK.get(paramInt);
    AppMethodBeat.o(268858);
    return localaw;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(268853);
    if (this.mlK == null)
    {
      AppMethodBeat.o(268853);
      return 0;
    }
    int i = this.mlK.size();
    AppMethodBeat.o(268853);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final void setData(ArrayList<aw> paramArrayList)
  {
    AppMethodBeat.i(268848);
    if (paramArrayList == null)
    {
      this.mlK = new ArrayList();
      this.bZE.notifyChanged();
      AppMethodBeat.o(268848);
      return;
    }
    if (this.JXS.size() > 0)
    {
      this.JXU.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        aw localaw = (aw)paramArrayList.get(i);
        if (this.JXS.contains(String.valueOf(localaw.field_labelID))) {
          this.JXU.add(String.valueOf(localaw.field_labelID));
        }
        i += 1;
      }
      this.JXy.clear();
      this.JXy.addAll(this.JXU);
    }
    this.mlK = paramArrayList;
    this.bZE.notifyChanged();
    AppMethodBeat.o(268848);
  }
  
  public static abstract interface a
  {
    public abstract void aD(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchLabel.a
 * JD-Core Version:    0.7.0.1
 */
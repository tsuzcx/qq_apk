package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.label.ui.e;
import com.tencent.mm.plugin.label.ui.searchLabel.LabelSearchUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends RecyclerView.a<e>
  implements d
{
  public k HPR;
  public HashMap<Integer, Integer> JVs;
  private List<String> JXU;
  public int JXV;
  public View.OnTouchListener JXX;
  public List<String> JXy;
  public boolean JYA;
  public boolean JYB;
  private long JYC;
  public boolean JYD;
  public e JYE;
  public boolean JYt;
  public a JYu;
  public int JYv;
  public int JYw;
  public int JYx;
  public aw JYy;
  private boolean JYz;
  private Context mContext;
  public ArrayList<aw> mlK;
  private long startTime;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(268760);
    this.JYt = true;
    this.mlK = new ArrayList();
    this.JXy = new LinkedList();
    this.JXU = new LinkedList();
    this.JXV = 0;
    this.JYv = 0;
    this.JYw = -1;
    this.JYx = -1;
    this.JVs = new HashMap();
    this.JYy = new aw();
    this.JYz = false;
    this.JXX = null;
    this.JYA = false;
    this.JYB = false;
    this.JYC = -1L;
    this.JYD = true;
    this.JYE = null;
    this.mContext = paramContext;
    this.JYy.field_labelID = -2000000;
    this.JYy.field_isTemporary = true;
    AppMethodBeat.o(268760);
  }
  
  public final aw Zz(int paramInt)
  {
    AppMethodBeat.i(268824);
    if ((this.mlK == null) || (paramInt > this.mlK.size()))
    {
      AppMethodBeat.o(268824);
      return null;
    }
    aw localaw = (aw)this.mlK.get(paramInt);
    AppMethodBeat.o(268824);
    return localaw;
  }
  
  public final void fTB() {}
  
  public final void fTJ()
  {
    AppMethodBeat.i(268842);
    Intent localIntent;
    if (this.JYE != null)
    {
      localIntent = new Intent(this.mContext, LabelSearchUI.class);
      if (this.JXV != 1) {
        break label80;
      }
      localIntent.putExtra("edit_mode_state", 1);
    }
    for (;;)
    {
      localIntent.putExtra("contact_has_choose_label_list", Util.listToString(this.JXy, ","));
      this.JYE.aX(localIntent);
      AppMethodBeat.o(268842);
      return;
      label80:
      localIntent.putExtra("edit_mode_state", 0);
    }
  }
  
  public final void fTs() {}
  
  public final int getItemCount()
  {
    AppMethodBeat.i(268823);
    if (this.mlK == null)
    {
      AppMethodBeat.o(268823);
      return 0;
    }
    int i = this.mlK.size();
    AppMethodBeat.o(268823);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(268838);
    aw localaw = (aw)this.mlK.get(paramInt);
    if ((localaw != null) && (localaw.field_labelID == -1000000))
    {
      AppMethodBeat.o(268838);
      return 2;
    }
    if ((localaw != null) && (localaw.field_labelID == -2000000))
    {
      AppMethodBeat.o(268838);
      return 3;
    }
    if ((this.JVs != null) && (this.JVs.containsKey(Integer.valueOf(localaw.field_labelID))) && (((Integer)this.JVs.get(Integer.valueOf(localaw.field_labelID))).intValue() > 0))
    {
      AppMethodBeat.o(268838);
      return 0;
    }
    AppMethodBeat.o(268838);
    return 1;
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(268833);
    if (this.JXy != null) {
      this.JXy.clear();
    }
    this.JYv = 0;
    this.JYw = -1;
    AppMethodBeat.o(268833);
  }
  
  public final void setData(ArrayList<aw> paramArrayList)
  {
    boolean bool = false;
    AppMethodBeat.i(268799);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (this.JXy != null) {
        this.JXy.clear();
      }
      this.bZE.notifyChanged();
      AppMethodBeat.o(268799);
      return;
    }
    if (this.JXy.size() > 0)
    {
      i = 0;
      while (i < this.mlK.size())
      {
        aw localaw = (aw)this.mlK.get(i);
        if (this.JXy.contains(Integer.valueOf(localaw.field_labelID))) {
          this.JXU.add(String.valueOf(localaw.field_labelID));
        }
        i += 1;
      }
      this.JXy.clear();
      this.JXy.addAll(this.JXU);
      this.JXU.clear();
    }
    int j;
    if (this.JYu != null)
    {
      this.JYB = true;
      if (this.JXV == 1)
      {
        paramArrayList.remove(this.JYu);
        if ((this.JYD) && (!paramArrayList.contains(this.JYy))) {
          paramArrayList.add(0, this.JYy);
        }
        j = paramArrayList.size();
        if (!this.JYB) {
          break label299;
        }
      }
    }
    label299:
    for (int i = 1;; i = 0)
    {
      if (j > i) {
        bool = true;
      }
      this.JYA = bool;
      this.mlK = paramArrayList;
      this.bZE.notifyChanged();
      AppMethodBeat.o(268799);
      return;
      if (paramArrayList.contains(this.JYu)) {
        break;
      }
      paramArrayList.add(this.JYu);
      break;
      this.JYB = false;
      break;
    }
  }
  
  public final void xS(boolean paramBoolean)
  {
    AppMethodBeat.i(268790);
    if (this.JYz != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.JYz = paramBoolean;
      if (i != 0) {
        this.bZE.notifyChanged();
      }
      AppMethodBeat.o(268790);
      return;
    }
  }
  
  public final void xT(boolean paramBoolean)
  {
    AppMethodBeat.i(268817);
    this.JYt = paramBoolean;
    this.bZE.notifyChanged();
    AppMethodBeat.o(268817);
  }
  
  public static final class a
    extends aw
  {
    public List<String> JYH;
    public int JYI;
  }
  
  public static abstract interface e
  {
    public abstract void aD(View paramView, int paramInt);
    
    public abstract void aE(View paramView, int paramInt);
    
    public abstract void aX(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */
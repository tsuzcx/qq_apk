package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BaseAdapter
{
  byte[] buffer;
  private Context context;
  boolean eRq;
  boolean gzX;
  String key;
  String lbI;
  int lxQ;
  List<f> ogN;
  boolean ogy;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(113656);
    this.ogN = new ArrayList();
    this.context = null;
    this.lxQ = 0;
    this.buffer = null;
    this.eRq = false;
    this.key = "";
    this.lbI = "";
    this.gzX = false;
    this.ogy = false;
    this.context = paramContext;
    AppMethodBeat.o(113656);
  }
  
  private Spannable Sm(String paramString)
  {
    AppMethodBeat.i(113664);
    paramString = com.tencent.mm.plugin.fts.a.f.a(paramString, this.lbI);
    AppMethodBeat.o(113664);
    return paramString;
  }
  
  public final void Sl(String paramString)
  {
    AppMethodBeat.i(113658);
    this.key = paramString;
    ab.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[] { paramString });
    AppMethodBeat.o(113658);
  }
  
  public final void a(List<f> paramList, byte[] paramArrayOfByte, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(113660);
    if ((this.key == null) || (!this.key.equals(paramString)))
    {
      ab.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[] { this.key, paramString });
      AppMethodBeat.o(113660);
      return;
    }
    int i = this.ogN.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (f)paramList.next();
      paramString.ohf = i;
      i += 1;
      this.ogN.add(paramString);
    }
    this.buffer = paramArrayOfByte;
    this.eRq = paramBoolean;
    notifyDataSetChanged();
    AppMethodBeat.o(113660);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(113659);
    if (this.ogN.size() >= 0)
    {
      this.ogN.add(0, paramf);
      notifyDataSetChanged();
    }
    AppMethodBeat.o(113659);
  }
  
  public final void bMq()
  {
    this.buffer = null;
    this.eRq = false;
    this.key = "";
  }
  
  public final void clean()
  {
    AppMethodBeat.i(113657);
    this.buffer = null;
    this.eRq = false;
    this.key = "";
    this.ogN.clear();
    AppMethodBeat.o(113657);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113661);
    int i = this.ogN.size();
    AppMethodBeat.o(113661);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(113663);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130970426, null);
      paramViewGroup = new e.a();
      paramViewGroup.titleView = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.ogO = ((TextView)paramView.findViewById(2131821949));
      paramViewGroup.ogP = ((ImageView)paramView.findViewById(2131826753));
      paramViewGroup.ogR = paramView.findViewById(2131826755);
      paramViewGroup.ogQ = paramView.findViewById(2131826754);
      paramViewGroup.iQQ = ((TextView)paramView.findViewById(2131826756));
      paramView.setTag(paramViewGroup);
      if ((((f)this.ogN.get(paramInt)).type != 1) && (((f)this.ogN.get(paramInt)).type != 2)) {
        break label314;
      }
      paramViewGroup.ogR.setVisibility(0);
      paramViewGroup.ogQ.setVisibility(8);
      paramViewGroup.iQQ.setText(bo.bf(((f)this.ogN.get(paramInt)).ogS, ""));
      label198:
      if ((paramInt != 0) || (this.gzX)) {
        break label480;
      }
      if (!this.ogy) {
        break label334;
      }
      paramViewGroup.titleView.setText(bo.bf(((f)this.ogN.get(0)).mName, ""));
      paramViewGroup.ogO.setVisibility(0);
      paramViewGroup.ogO.setText(bo.bf(((f)this.ogN.get(0)).ogS, ""));
    }
    label296:
    label314:
    label334:
    label480:
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (paramInt == this.lxQ)
      {
        paramViewGroup.ogP.setVisibility(0);
        AppMethodBeat.o(113663);
        return paramView;
        paramViewGroup = (e.a)paramView.getTag();
        break;
        paramViewGroup.ogR.setVisibility(8);
        paramViewGroup.ogQ.setVisibility(0);
        break label198;
        paramViewGroup.ogO.setVisibility(8);
        if (!bo.isNullOrNil(((f)this.ogN.get(0)).ogS))
        {
          paramViewGroup.titleView.setText(bo.bf(((f)this.ogN.get(paramInt)).ogS, ""));
        }
        else if (bo.isNullOrNil(((f)this.ogN.get(0)).ohb))
        {
          paramViewGroup.titleView.setText(bo.bf(((f)this.ogN.get(paramInt)).mName, ""));
        }
        else
        {
          paramViewGroup.titleView.setText(bo.bf(((f)this.ogN.get(paramInt)).ohb, ""));
          continue;
          localObject2 = (f)this.ogN.get(paramInt);
          localObject1 = bo.bf(((f)localObject2).mName, "");
          localObject2 = bo.bf(((f)localObject2).ogS, "");
          if ((!this.gzX) || (bo.isNullOrNil(this.lbI))) {
            break label592;
          }
          localObject1 = Sm((String)localObject1);
          localObject2 = Sm((String)localObject2);
        }
      }
    }
    label592:
    for (;;)
    {
      paramViewGroup.titleView.setText((CharSequence)localObject1);
      paramViewGroup.ogO.setText((CharSequence)localObject2);
      paramViewGroup.ogO.setVisibility(0);
      break;
      paramViewGroup.ogP.setVisibility(4);
      break label296;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(113665);
    super.notifyDataSetChanged();
    Thread.currentThread().getId();
    Looper.getMainLooper().getThread().getId();
    ab.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bo.dtY().toString() + " threadId : " + Thread.currentThread().getId());
    AppMethodBeat.o(113665);
  }
  
  public final f ye(int paramInt)
  {
    AppMethodBeat.i(113662);
    f localf = (f)this.ogN.get(paramInt);
    AppMethodBeat.o(113662);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class a
  extends BaseAdapter
{
  private String IWx;
  private GameTabData IXL;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.IXL = paramGameTabData;
    this.IWx = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.IXL == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.IXL.aVf().size();
    AppMethodBeat.o(42432);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42433);
    paramView = LayoutInflater.from(this.mContext).inflate(h.f.Iaq, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.IXL.aVf().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.mll.setText(localTabItem.title);
      if (!Util.nullAsNil(this.IWx).equalsIgnoreCase(localTabItem.IFL)) {
        break label186;
      }
      if (!Util.isNullOrNil(localTabItem.IFR))
      {
        localObject = aj.IFV + g.getMessageDigest(localTabItem.IFR.getBytes());
        locala = new c.a();
        locala.oKp = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bKx();
        com.tencent.mm.modelimage.loader.a.bKl().a(localTabItem.IFR, paramViewGroup.dpM, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label186:
      if (!Util.isNullOrNil(localTabItem.IFQ))
      {
        localObject = aj.IFV + g.getMessageDigest(localTabItem.IFQ.getBytes());
        locala = new c.a();
        locala.oKp = true;
        locala.fullPath = ((String)localObject);
        localObject = locala.bKx();
        com.tencent.mm.modelimage.loader.a.bKl().a(localTabItem.IFQ, paramViewGroup.dpM, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    ImageView dpM;
    TextView mll;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.mll = ((TextView)paramView.findViewById(h.e.HTD));
      this.dpM = ((ImageView)paramView.findViewById(h.e.HTB));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */
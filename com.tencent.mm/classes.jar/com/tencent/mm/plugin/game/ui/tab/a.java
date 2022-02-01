package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private String uud;
  private GameTabData uve;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.uve = paramGameTabData;
    this.uud = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.uve == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.uve.afl().size();
    AppMethodBeat.o(42432);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42433);
    paramView = LayoutInflater.from(this.mContext).inflate(2131494391, paramViewGroup, false);
    paramViewGroup = new a(paramView);
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.uve.afl().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.gnM.setText(localTabItem.title);
      if (!bt.nullAsNil(this.uud).equalsIgnoreCase(localTabItem.uea)) {
        break label185;
      }
      if (!bt.isNullOrNil(localTabItem.ueg))
      {
        localObject = aj.uel + g.getMessageDigest(localTabItem.ueg.getBytes());
        locala = new c.a();
        locala.idr = true;
        locala.hdP = ((String)localObject);
        localObject = locala.aJc();
        com.tencent.mm.aw.a.a.aIP().a(localTabItem.ueg, paramViewGroup.ka, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label185:
      if (!bt.isNullOrNil(localTabItem.uef))
      {
        localObject = aj.uel + g.getMessageDigest(localTabItem.uef.getBytes());
        locala = new c.a();
        locala.idr = true;
        locala.hdP = ((String)localObject);
        localObject = locala.aJc();
        com.tencent.mm.aw.a.a.aIP().a(localTabItem.uef, paramViewGroup.ka, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    TextView gnM;
    ImageView ka;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.gnM = ((TextView)paramView.findViewById(2131297471));
      this.ka = ((ImageView)paramView.findViewById(2131297469));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */
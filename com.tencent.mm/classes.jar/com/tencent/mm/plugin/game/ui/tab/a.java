package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private String uFx;
  private GameTabData uGD;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(GameTabData paramGameTabData, String paramString)
  {
    AppMethodBeat.i(42431);
    this.uGD = paramGameTabData;
    this.uFx = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(42431);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42432);
    if (this.uGD == null)
    {
      AppMethodBeat.o(42432);
      return 0;
    }
    int i = this.uGD.afz().size();
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
    GameTabData.TabItem localTabItem = (GameTabData.TabItem)this.uGD.afz().get(paramInt);
    Object localObject;
    c.a locala;
    if (localTabItem != null)
    {
      paramViewGroup.gqi.setText(localTabItem.title);
      if (!bu.nullAsNil(this.uFx).equalsIgnoreCase(localTabItem.upi)) {
        break label185;
      }
      if (!bu.isNullOrNil(localTabItem.upo))
      {
        localObject = aj.ups + g.getMessageDigest(localTabItem.upo.getBytes());
        locala = new c.a();
        locala.igk = true;
        locala.hgD = ((String)localObject);
        localObject = locala.aJu();
        com.tencent.mm.av.a.a.aJh().a(localTabItem.upo, paramViewGroup.ka, (c)localObject);
      }
    }
    for (;;)
    {
      paramView.setTag(localTabItem);
      AppMethodBeat.o(42433);
      return paramView;
      label185:
      if (!bu.isNullOrNil(localTabItem.upn))
      {
        localObject = aj.ups + g.getMessageDigest(localTabItem.upn.getBytes());
        locala = new c.a();
        locala.igk = true;
        locala.hgD = ((String)localObject);
        localObject = locala.aJu();
        com.tencent.mm.av.a.a.aJh().a(localTabItem.upn, paramViewGroup.ka, (c)localObject);
      }
    }
  }
  
  public final class a
  {
    TextView gqi;
    ImageView ka;
    
    public a(View paramView)
    {
      AppMethodBeat.i(42430);
      this.gqi = ((TextView)paramView.findViewById(2131297471));
      this.ka = ((ImageView)paramView.findViewById(2131297469));
      AppMethodBeat.o(42430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.a
 * JD-Core Version:    0.7.0.1
 */
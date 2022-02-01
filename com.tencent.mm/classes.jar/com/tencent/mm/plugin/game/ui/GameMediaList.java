package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameMediaList
  extends LinearLayout
  implements View.OnClickListener
{
  String appId = "";
  Context mContext;
  int pOf = -1;
  int sjf = 0;
  private int skG;
  private LinkedList<String> skH;
  
  public GameMediaList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42256);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.i("MicroMsg.GameMediaList", "Invalid tag");
      AppMethodBeat.o(42256);
      return;
    }
    paramView = (a)paramView.getTag();
    switch (paramView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42256);
      return;
      c.ax(getContext(), paramView.url);
      e.a(this.mContext, this.pOf, 1202, 1, 13, this.appId, this.sjf, null);
      AppMethodBeat.o(42256);
      return;
      paramView = paramView.url;
      int j = this.skH.indexOf(paramView);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramView = new Intent(getContext(), GameGalleryUI.class);
      Object localObject = new String[this.skH.size()];
      this.skH.toArray((Object[])localObject);
      paramView.putExtra("URLS", (String[])localObject);
      paramView.putExtra("CURRENT", i);
      paramView.putExtra("REPORT_APPID", this.appId);
      paramView.putExtra("REPORT_SCENE", this.pOf);
      paramView.putExtra("SOURCE_SCENE", this.sjf);
      localObject = getContext();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void setItemLayout(int paramInt)
  {
    this.skG = paramInt;
  }
  
  public void setMediaList(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(42255);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(42255);
      return;
    }
    this.skH = new LinkedList();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localObject = (a)paramLinkedList.get(i);
      if ((!bt.isNullOrNil(((a)localObject).url)) && (((a)localObject).type == 0)) {
        this.skH.add(((a)localObject).url);
      }
      i += 1;
    }
    removeAllViews();
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    i = 0;
    while (i < paramLinkedList.size())
    {
      a locala = (a)paramLinkedList.get(i);
      if (!bt.isNullOrNil(locala.skI))
      {
        View localView = ((LayoutInflater)localObject).inflate(this.skG, this, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131302221);
        com.tencent.mm.aw.a.a locala1 = o.ayJ();
        String str = locala.skI;
        c.a locala2 = new c.a();
        locala2.hjT = true;
        locala1.a(str, localImageView, locala2.azc());
        if (locala.type == 1) {
          localView.findViewById(2131302215).setVisibility(0);
        }
        addView(localView);
        localImageView.setTag(locala);
        localImageView.setOnClickListener(this);
      }
      i += 1;
    }
    setVisibility(0);
    AppMethodBeat.o(42255);
  }
  
  public static final class a
  {
    public String skI;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMediaList
 * JD-Core Version:    0.7.0.1
 */
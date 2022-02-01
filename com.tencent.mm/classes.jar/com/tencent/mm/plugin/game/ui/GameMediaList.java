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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMediaList
  extends LinearLayout
  implements View.OnClickListener
{
  String appId = "";
  Context mContext;
  int sQn = -1;
  int xSP = 0;
  private int xUq;
  private LinkedList<String> xUr;
  
  public GameMediaList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42256);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      Log.i("MicroMsg.GameMediaList", "Invalid tag");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42256);
      return;
    }
    paramView = (a)paramView.getTag();
    switch (paramView.type)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42256);
      return;
      c.aQ(getContext(), paramView.url);
      f.a(this.mContext, this.sQn, 1202, 1, 13, this.appId, this.xSP, null);
      continue;
      paramView = paramView.url;
      int j = this.xUr.indexOf(paramView);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramView = new Intent(getContext(), GameGalleryUI.class);
      localObject = new String[this.xUr.size()];
      this.xUr.toArray((Object[])localObject);
      paramView.putExtra("URLS", (String[])localObject);
      paramView.putExtra("CURRENT", i);
      paramView.putExtra("REPORT_APPID", this.appId);
      paramView.putExtra("REPORT_SCENE", this.sQn);
      paramView.putExtra("SOURCE_SCENE", this.xSP);
      localObject = getContext();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void setItemLayout(int paramInt)
  {
    this.xUq = paramInt;
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
    this.xUr = new LinkedList();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localObject = (a)paramLinkedList.get(i);
      if ((!Util.isNullOrNil(((a)localObject).url)) && (((a)localObject).type == 0)) {
        this.xUr.add(((a)localObject).url);
      }
      i += 1;
    }
    removeAllViews();
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    i = 0;
    while (i < paramLinkedList.size())
    {
      a locala = (a)paramLinkedList.get(i);
      if (!Util.isNullOrNil(locala.dkZ))
      {
        View localView = ((LayoutInflater)localObject).inflate(this.xUq, this, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131304573);
        com.tencent.mm.av.a.a locala1 = q.bcV();
        String str = locala.dkZ;
        c.a locala2 = new c.a();
        locala2.jbe = true;
        locala1.a(str, localImageView, locala2.bdv());
        if (locala.type == 1) {
          localView.findViewById(2131304566).setVisibility(0);
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
    public String dkZ;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMediaList
 * JD-Core Version:    0.7.0.1
 */
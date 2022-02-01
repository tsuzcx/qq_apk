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
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameMediaList
  extends LinearLayout
  implements View.OnClickListener
{
  String appId = "";
  Context mContext;
  int roH = -1;
  int uAR = 0;
  private int uCs;
  private LinkedList<String> uCt;
  
  public GameMediaList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42256);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameMediaList.a)))
    {
      ae.i("MicroMsg.GameMediaList", "Invalid tag");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42256);
      return;
    }
    paramView = (GameMediaList.a)paramView.getTag();
    switch (paramView.type)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42256);
      return;
      c.aD(getContext(), paramView.url);
      f.a(this.mContext, this.roH, 1202, 1, 13, this.appId, this.uAR, null);
      continue;
      paramView = paramView.url;
      int j = this.uCt.indexOf(paramView);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramView = new Intent(getContext(), GameGalleryUI.class);
      localObject = new String[this.uCt.size()];
      this.uCt.toArray((Object[])localObject);
      paramView.putExtra("URLS", (String[])localObject);
      paramView.putExtra("CURRENT", i);
      paramView.putExtra("REPORT_APPID", this.appId);
      paramView.putExtra("REPORT_SCENE", this.roH);
      paramView.putExtra("SOURCE_SCENE", this.uAR);
      localObject = getContext();
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void setItemLayout(int paramInt)
  {
    this.uCs = paramInt;
  }
  
  public void setMediaList(LinkedList<GameMediaList.a> paramLinkedList)
  {
    AppMethodBeat.i(42255);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(42255);
      return;
    }
    this.uCt = new LinkedList();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localObject = (GameMediaList.a)paramLinkedList.get(i);
      if ((!bu.isNullOrNil(((GameMediaList.a)localObject).url)) && (((GameMediaList.a)localObject).type == 0)) {
        this.uCt.add(((GameMediaList.a)localObject).url);
      }
      i += 1;
    }
    removeAllViews();
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    i = 0;
    while (i < paramLinkedList.size())
    {
      GameMediaList.a locala = (GameMediaList.a)paramLinkedList.get(i);
      if (!bu.isNullOrNil(locala.cUF))
      {
        View localView = ((LayoutInflater)localObject).inflate(this.uCs, this, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131302221);
        com.tencent.mm.av.a.a locala1 = q.aJb();
        String str = locala.cUF;
        c.a locala2 = new c.a();
        locala2.igj = true;
        locala1.a(str, localImageView, locala2.aJu());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMediaList
 * JD-Core Version:    0.7.0.1
 */
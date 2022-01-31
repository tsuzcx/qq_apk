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
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameMediaList
  extends LinearLayout
  implements View.OnClickListener
{
  String appId = "";
  Context mContext;
  int mhr = -1;
  private int nBj;
  private LinkedList<String> nBk;
  int nzF = 0;
  
  public GameMediaList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112066);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ab.i("MicroMsg.GameMediaList", "Invalid tag");
      AppMethodBeat.o(112066);
      return;
    }
    paramView = (a)paramView.getTag();
    switch (paramView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112066);
      return;
      com.tencent.mm.plugin.game.f.c.ax(getContext(), paramView.url);
      com.tencent.mm.game.report.c.a(this.mContext, this.mhr, 1202, 1, 13, this.appId, this.nzF, null);
      AppMethodBeat.o(112066);
      return;
      paramView = paramView.url;
      int j = this.nBk.indexOf(paramView);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramView = new Intent(getContext(), GameGalleryUI.class);
      String[] arrayOfString = new String[this.nBk.size()];
      this.nBk.toArray(arrayOfString);
      paramView.putExtra("URLS", arrayOfString);
      paramView.putExtra("CURRENT", i);
      paramView.putExtra("REPORT_APPID", this.appId);
      paramView.putExtra("REPORT_SCENE", this.mhr);
      paramView.putExtra("SOURCE_SCENE", this.nzF);
      getContext().startActivity(paramView);
    }
  }
  
  public void setItemLayout(int paramInt)
  {
    this.nBj = paramInt;
  }
  
  public void setMediaList(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(112065);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(112065);
      return;
    }
    this.nBk = new LinkedList();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localObject = (a)paramLinkedList.get(i);
      if ((!bo.isNullOrNil(((a)localObject).url)) && (((a)localObject).type == 0)) {
        this.nBk.add(((a)localObject).url);
      }
      i += 1;
    }
    removeAllViews();
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    i = 0;
    while (i < paramLinkedList.size())
    {
      a locala = (a)paramLinkedList.get(i);
      if (!bo.isNullOrNil(locala.nBl))
      {
        View localView = ((LayoutInflater)localObject).inflate(this.nBj, this, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131822416);
        a locala1 = o.ahG();
        String str = locala.nBl;
        c.a locala2 = new c.a();
        locala2.eNL = true;
        locala1.a(str, localImageView, locala2.ahY());
        if (locala.type == 1) {
          localView.findViewById(2131824691).setVisibility(0);
        }
        addView(localView);
        localImageView.setTag(locala);
        localImageView.setOnClickListener(this);
      }
      i += 1;
    }
    setVisibility(0);
    AppMethodBeat.o(112065);
  }
  
  public static final class a
  {
    public String nBl;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMediaList
 * JD-Core Version:    0.7.0.1
 */
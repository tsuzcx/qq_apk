package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class GameMediaList
  extends LinearLayout
  implements View.OnClickListener
{
  String appId = "";
  int jNi = -1;
  int lbK = 0;
  private int ldo;
  private LinkedList<String> ldp;
  Context mContext;
  
  public GameMediaList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      y.i("MicroMsg.GameMediaList", "Invalid tag");
      return;
    }
    paramView = (a)paramView.getTag();
    switch (paramView.type)
    {
    default: 
      return;
    case 0: 
      paramView = paramView.url;
      int j = this.ldp.indexOf(paramView);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramView = new Intent(getContext(), GameGalleryUI.class);
      String[] arrayOfString = new String[this.ldp.size()];
      this.ldp.toArray(arrayOfString);
      paramView.putExtra("URLS", arrayOfString);
      paramView.putExtra("CURRENT", i);
      paramView.putExtra("REPORT_APPID", this.appId);
      paramView.putExtra("REPORT_SCENE", this.jNi);
      paramView.putExtra("SOURCE_SCENE", this.lbK);
      getContext().startActivity(paramView);
      return;
    }
    c.an(getContext(), paramView.url);
    b.a(this.mContext, this.jNi, 1202, 1, 13, this.appId, this.lbK, null);
  }
  
  public void setItemLayout(int paramInt)
  {
    this.ldo = paramInt;
  }
  
  public void setMediaList(LinkedList<a> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.ldp = new LinkedList();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localObject = (a)paramLinkedList.get(i);
      if ((!bk.bl(((a)localObject).url)) && (((a)localObject).type == 0)) {
        this.ldp.add(((a)localObject).url);
      }
      i += 1;
    }
    removeAllViews();
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    i = 0;
    while (i < paramLinkedList.size())
    {
      a locala = (a)paramLinkedList.get(i);
      if (!bk.bl(locala.ldq))
      {
        View localView = ((LayoutInflater)localObject).inflate(this.ldo, this, false);
        ImageView localImageView = (ImageView)localView.findViewById(g.e.media_thumb);
        a locala1 = o.ON();
        String str = locala.ldq;
        c.a locala2 = new c.a();
        locala2.ere = true;
        locala1.a(str, localImageView, locala2.OV());
        if (locala.type == 1) {
          localView.findViewById(g.e.media_overlay).setVisibility(0);
        }
        addView(localView);
        localImageView.setTag(locala);
        localImageView.setOnClickListener(this);
      }
      i += 1;
    }
    setVisibility(0);
  }
  
  public static final class a
  {
    public String ldq;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMediaList
 * JD-Core Version:    0.7.0.1
 */
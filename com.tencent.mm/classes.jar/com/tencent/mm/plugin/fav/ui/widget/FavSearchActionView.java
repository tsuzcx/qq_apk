package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  public FavTagPanel kdq;
  public List<Integer> keI = new LinkedList();
  private ImageButton kjB;
  private ImageView kjC;
  public List<String> kjD = new LinkedList();
  public List<String> kjE = new LinkedList();
  public FavSearchActionView.a kjF;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void aSb()
  {
    if ((this.keI.isEmpty()) && (this.kjD.isEmpty()))
    {
      this.kdq.setEditHint(getResources().getString(n.i.app_search));
      return;
    }
    this.kdq.setEditHint("");
  }
  
  public static Integer ag(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return Integer.valueOf(-1);
    }
    if (paramContext.getString(n.i.favorite_sub_title_imageandvideo).equals(paramString)) {
      return Integer.valueOf(21);
    }
    if (paramContext.getString(n.i.favorite_sub_title_url).equals(paramString)) {
      return Integer.valueOf(5);
    }
    if (paramContext.getString(n.i.favorite_sub_title_file).equals(paramString)) {
      return Integer.valueOf(8);
    }
    if (paramContext.getString(n.i.favorite_sub_title_music).equals(paramString)) {
      return Integer.valueOf(7);
    }
    if (paramContext.getString(n.i.favorite_sub_title_record).equals(paramString)) {
      return Integer.valueOf(17);
    }
    if (paramContext.getString(n.i.favorite_sub_title_voice).equals(paramString)) {
      return Integer.valueOf(3);
    }
    if (paramContext.getString(n.i.favorite_sub_title_note).equals(paramString)) {
      return Integer.valueOf(18);
    }
    if (paramContext.getString(n.i.favorite_sub_title_location).equals(paramString)) {
      return Integer.valueOf(6);
    }
    return Integer.valueOf(-1);
  }
  
  public final void Dd(String paramString)
  {
    this.kjE.clear();
    paramString = bk.aM(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!bk.bl(str)) {
        this.kjE.add(str);
      }
      i += 1;
    }
  }
  
  public final void M(int paramInt, boolean paramBoolean)
  {
    this.keI.clear();
    this.keI.add(Integer.valueOf(paramInt));
    if (this.kdq == null) {
      return;
    }
    aSb();
    FavTagPanel localFavTagPanel = this.kdq;
    Object localObject = getContext();
    if (localObject != null) {}
    switch (paramInt)
    {
    case 4: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 19: 
    case 20: 
    default: 
      localObject = "";
    }
    for (;;)
    {
      localFavTagPanel.setType((String)localObject);
      if (this.kjF == null) {
        break;
      }
      Dd(this.kdq.getEditText());
      if (paramBoolean) {
        this.kjF.a(this.keI, this.kjE, this.kjD, false);
      }
      h.nFQ.f(11126, new Object[] { Integer.valueOf(1) });
      return;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_imageandvideo);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_url);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_file);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_music);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_record);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_voice);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_note);
      continue;
      localObject = ((Context)localObject).getString(n.i.favorite_sub_title_location);
    }
  }
  
  public List<String> getSearchKeys()
  {
    if (this.kdq != null) {
      Dd(this.kdq.getEditText());
    }
    return this.kjE;
  }
  
  public List<String> getSearchTags()
  {
    return this.kjD;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kjB = ((ImageButton)findViewById(n.e.search_clear_button));
    this.kdq = ((FavTagPanel)findViewById(n.e.fav_tag_input_panel));
    this.kjC = ((ImageView)findViewById(n.e.ab_back_btn));
    if (this.kdq != null)
    {
      this.kdq.setEditTextColor(getResources().getColor(n.b.black_text_color));
      this.kdq.setTagTipsDrawable(0);
      this.kdq.setTagHighlineBG(0);
      this.kdq.setTagSelectedBG(0);
      this.kdq.setTagSelectedTextColorRes(n.b.green_text_color);
      this.kdq.setTagNormalBG(0);
      this.kdq.setTagNormalTextColorRes(n.b.white);
      this.kdq.setEditHint(getResources().getString(n.i.app_search));
      this.kdq.nc(true);
      this.kdq.uXY = false;
      this.kdq.uXZ = true;
      this.kdq.setCallBack(new FavSearchActionView.1(this));
    }
    if (this.kjB != null) {
      this.kjB.setOnClickListener(new FavSearchActionView.2(this));
    }
  }
  
  public void setOnSearchChangedListener(FavSearchActionView.a parama)
  {
    this.kjF = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */
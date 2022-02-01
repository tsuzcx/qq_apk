package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.dimen;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.picker.base.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.List;

public class KindaPickerViewImpl<T>
  extends LinearLayout
{
  private static final String TAG = "KindaPickerViewImpl";
  private boolean mIsLinkage;
  private List<T> mLeftWheelItems;
  private OnSelectChangeListener mOnSelectChangeListener;
  private List<? extends List<T>> mRightWheelItems;
  private WheelView mWheelViewLeft;
  private WheelView mWheelViewRight;
  
  public KindaPickerViewImpl(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(263778);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(263778);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(263779);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(263779);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(263780);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(263780);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(263781);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(263781);
  }
  
  private void forceSetSelectedItems(List<Integer> paramList)
  {
    AppMethodBeat.i(263798);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(263798);
      return;
    }
    if (this.mLeftWheelItems != null) {
      this.mWheelViewLeft.setCurrentItem(((Integer)paramList.get(0)).intValue());
    }
    if ((this.mRightWheelItems != null) && (paramList.size() > 1))
    {
      this.mWheelViewRight.setAdapter(new com.tencent.mm.picker.a.a((List)this.mRightWheelItems.get(((Integer)paramList.get(0)).intValue())));
      this.mWheelViewRight.setCurrentItem(((Integer)paramList.get(1)).intValue());
    }
    AppMethodBeat.o(263798);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(263782);
    ad.kS(paramContext).inflate(R.layout.kinda_picker_view, this);
    this.mWheelViewLeft = ((WheelView)findViewById(R.id.options_left));
    this.mWheelViewRight = ((WheelView)findViewById(R.id.options_right));
    setDividerHeight(paramContext.getResources().getDimensionPixelSize(R.dimen.bottomsheet_dividing_line_height));
    setDividerColor(androidx.core.content.a.w(paramContext, R.color.BW_0_Alpha_0_1));
    setPadding(0, paramContext.getResources().getDimensionPixelSize(R.dimen.Edge_2A), 0, paramContext.getResources().getDimensionPixelSize(a.d.Edge_2A));
    setItemHeight(paramContext.getResources().getDimensionPixelSize(R.dimen.Edge_2A));
    setTextColor(androidx.core.content.a.w(paramContext, R.color.BW_0_Alpha_0_9));
    setLoop(false);
    AppMethodBeat.o(263782);
  }
  
  public ArrayList<Integer> getCurrentItems()
  {
    AppMethodBeat.i(263788);
    ArrayList localArrayList = new ArrayList();
    int k = this.mWheelViewLeft.getCurrentItem();
    int i = this.mWheelViewRight.getCurrentItem();
    int j = i;
    if (this.mRightWheelItems != null)
    {
      j = i;
      if (this.mRightWheelItems.size() > 0)
      {
        if (i <= ((List)this.mRightWheelItems.get(k)).size() - 1) {
          break label109;
        }
        i = 0;
      }
    }
    label109:
    for (;;)
    {
      j = i;
      localArrayList.add(Integer.valueOf(k));
      localArrayList.add(Integer.valueOf(j));
      AppMethodBeat.o(263788);
      return localArrayList;
    }
  }
  
  public void setCurrentItems(List<Integer> paramList)
  {
    AppMethodBeat.i(263789);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(263789);
      return;
    }
    if (this.mIsLinkage)
    {
      forceSetSelectedItems(paramList);
      AppMethodBeat.o(263789);
      return;
    }
    this.mWheelViewLeft.setCurrentItem(((Integer)paramList.get(0)).intValue());
    if (paramList.size() > 1) {
      this.mWheelViewRight.setCurrentItem(((Integer)paramList.get(1)).intValue());
    }
    AppMethodBeat.o(263789);
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(263794);
    this.mWheelViewLeft.setDividerColor(paramInt);
    this.mWheelViewRight.setDividerColor(paramInt);
    AppMethodBeat.o(263794);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(263793);
    this.mWheelViewLeft.setDividerHeight(paramFloat);
    this.mWheelViewRight.setDividerHeight(paramFloat);
    AppMethodBeat.o(263793);
  }
  
  public void setIndividualPicker(List<? extends List<T>> paramList)
  {
    AppMethodBeat.i(263787);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(263787);
      return;
    }
    List localList2 = (List)paramList.get(0);
    List localList1 = null;
    if (paramList.size() > 1) {
      localList1 = (List)paramList.get(1);
    }
    this.mIsLinkage = false;
    this.mWheelViewLeft.setAdapter(new com.tencent.mm.picker.a.a(localList2));
    this.mWheelViewLeft.setCurrentItem(0);
    if (localList1 != null) {
      this.mWheelViewRight.setAdapter(new com.tencent.mm.picker.a.a(localList1));
    }
    this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
    this.mWheelViewLeft.setIsOptions(true);
    this.mWheelViewRight.setIsOptions(true);
    if (this.mOnSelectChangeListener == null)
    {
      AppMethodBeat.o(263787);
      return;
    }
    this.mWheelViewLeft.setOnItemSelectedListener(new b()
    {
      public void onItemSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(263653);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(paramAnonymousInt));
        localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewRight.getCurrentItem()));
        if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
        }
        AppMethodBeat.o(263653);
      }
    });
    if (localList1 != null) {
      this.mWheelViewRight.setOnItemSelectedListener(new b()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(263999);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
            KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          }
          AppMethodBeat.o(263999);
        }
      });
    }
    AppMethodBeat.o(263787);
  }
  
  public void setItemHeight(int paramInt)
  {
    AppMethodBeat.i(263791);
    this.mWheelViewLeft.xM(paramInt);
    this.mWheelViewRight.xM(paramInt);
    AppMethodBeat.o(263791);
  }
  
  public void setLinkagePicker(List<T> paramList, List<? extends List<T>> paramList1)
  {
    AppMethodBeat.i(263783);
    if (paramList == null)
    {
      AppMethodBeat.o(263783);
      return;
    }
    this.mLeftWheelItems = paramList;
    this.mRightWheelItems = paramList1;
    this.mIsLinkage = true;
    this.mWheelViewLeft.setAdapter(new com.tencent.mm.picker.a.a(this.mLeftWheelItems));
    this.mWheelViewLeft.setCurrentItem(0);
    if (this.mLeftWheelItems != null) {
      this.mWheelViewRight.setAdapter(new com.tencent.mm.picker.a.a((List)this.mRightWheelItems.get(0)));
    }
    this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
    if (paramList != null) {
      this.mWheelViewLeft.setOnItemSelectedListener(new b()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(264168);
          if (KindaPickerViewImpl.this.mOnSelectChangeListener == null)
          {
            AppMethodBeat.o(264168);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          localArrayList.add(Integer.valueOf(0));
          if (KindaPickerViewImpl.this.mRightWheelItems != null)
          {
            KindaPickerViewImpl.this.mWheelViewRight.setAdapter(new com.tencent.mm.picker.a.a((List)KindaPickerViewImpl.this.mRightWheelItems.get(paramAnonymousInt)));
            KindaPickerViewImpl.this.mWheelViewRight.setCurrentItem(0);
          }
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          AppMethodBeat.o(264168);
        }
      });
    }
    if (paramList1 != null) {
      this.mWheelViewRight.setOnItemSelectedListener(new b()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(263953);
          if (KindaPickerViewImpl.this.mOnSelectChangeListener == null)
          {
            AppMethodBeat.o(263953);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          AppMethodBeat.o(263953);
        }
      });
    }
    AppMethodBeat.o(263783);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(263792);
    this.mWheelViewLeft.setCyclic(paramBoolean);
    this.mWheelViewRight.setCyclic(paramBoolean);
    AppMethodBeat.o(263792);
  }
  
  public void setOnSelectChangeListener(OnSelectChangeListener paramOnSelectChangeListener)
  {
    this.mOnSelectChangeListener = paramOnSelectChangeListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(263795);
    this.mWheelViewLeft.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWheelViewRight.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(263795);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(263790);
    this.mWheelViewLeft.xN(paramInt);
    this.mWheelViewRight.xN(paramInt);
    AppMethodBeat.o(263790);
  }
  
  static abstract interface OnSelectChangeListener
  {
    public abstract void onSelected(ArrayList<Integer> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPickerViewImpl
 * JD-Core Version:    0.7.0.1
 */
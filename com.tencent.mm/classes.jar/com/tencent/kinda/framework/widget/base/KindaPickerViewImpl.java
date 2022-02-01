package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.ui.widget.picker.d.c;
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
    AppMethodBeat.i(214480);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(214480);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(214481);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(214481);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214482);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(214482);
  }
  
  public KindaPickerViewImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(214483);
    this.mIsLinkage = true;
    init(paramContext);
    AppMethodBeat.o(214483);
  }
  
  private void forceSetSelectedItems(List<Integer> paramList)
  {
    AppMethodBeat.i(214495);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(214495);
      return;
    }
    if (this.mLeftWheelItems != null) {
      this.mWheelViewLeft.setCurrentItem(((Integer)paramList.get(0)).intValue());
    }
    if ((this.mRightWheelItems != null) && (paramList.size() > 1))
    {
      this.mWheelViewRight.setAdapter(new a((List)this.mRightWheelItems.get(((Integer)paramList.get(0)).intValue())));
      this.mWheelViewRight.setCurrentItem(((Integer)paramList.get(1)).intValue());
    }
    AppMethodBeat.o(214495);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(214484);
    aa.jQ(paramContext).inflate(2131495147, this);
    this.mWheelViewLeft = ((WheelView)findViewById(2131305656));
    this.mWheelViewRight = ((WheelView)findViewById(2131305657));
    setDividerHeight(paramContext.getResources().getDimensionPixelSize(2131165950));
    setDividerColor(b.n(paramContext, 2131099657));
    setPadding(0, paramContext.getResources().getDimensionPixelSize(2131165296), 0, paramContext.getResources().getDimensionPixelSize(2131165296));
    setItemHeight(paramContext.getResources().getDimensionPixelSize(2131165296));
    setTextColor(b.n(paramContext, 2131099669));
    setLoop(false);
    AppMethodBeat.o(214484);
  }
  
  public ArrayList<Integer> getCurrentItems()
  {
    AppMethodBeat.i(214487);
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
      AppMethodBeat.o(214487);
      return localArrayList;
    }
  }
  
  public void setCurrentItems(List<Integer> paramList)
  {
    AppMethodBeat.i(214488);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(214488);
      return;
    }
    if (this.mIsLinkage)
    {
      forceSetSelectedItems(paramList);
      AppMethodBeat.o(214488);
      return;
    }
    this.mWheelViewLeft.setCurrentItem(((Integer)paramList.get(0)).intValue());
    if (paramList.size() > 1) {
      this.mWheelViewRight.setCurrentItem(((Integer)paramList.get(1)).intValue());
    }
    AppMethodBeat.o(214488);
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(214493);
    this.mWheelViewLeft.setDividerColor(paramInt);
    this.mWheelViewRight.setDividerColor(paramInt);
    AppMethodBeat.o(214493);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(214492);
    this.mWheelViewLeft.setDividerHeight(paramFloat);
    this.mWheelViewRight.setDividerHeight(paramFloat);
    AppMethodBeat.o(214492);
  }
  
  public void setIndividualPicker(List<? extends List<T>> paramList)
  {
    AppMethodBeat.i(214486);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(214486);
      return;
    }
    List localList2 = (List)paramList.get(0);
    List localList1 = null;
    if (paramList.size() > 1) {
      localList1 = (List)paramList.get(1);
    }
    this.mIsLinkage = false;
    this.mWheelViewLeft.setAdapter(new a(localList2));
    this.mWheelViewLeft.setCurrentItem(0);
    if (localList1 != null) {
      this.mWheelViewRight.setAdapter(new a(localList1));
    }
    this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
    this.mWheelViewLeft.setIsOptions(true);
    this.mWheelViewRight.setIsOptions(true);
    if (this.mOnSelectChangeListener == null)
    {
      AppMethodBeat.o(214486);
      return;
    }
    this.mWheelViewLeft.setOnItemSelectedListener(new c()
    {
      public void onItemSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(214478);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(paramAnonymousInt));
        localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewRight.getCurrentItem()));
        if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
        }
        AppMethodBeat.o(214478);
      }
    });
    if (localList1 != null) {
      this.mWheelViewRight.setOnItemSelectedListener(new c()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(214479);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
            KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          }
          AppMethodBeat.o(214479);
        }
      });
    }
    AppMethodBeat.o(214486);
  }
  
  public void setItemHeight(int paramInt)
  {
    AppMethodBeat.i(214490);
    this.mWheelViewLeft.apr(paramInt);
    this.mWheelViewRight.apr(paramInt);
    AppMethodBeat.o(214490);
  }
  
  public void setLinkagePicker(List<T> paramList, List<? extends List<T>> paramList1)
  {
    AppMethodBeat.i(214485);
    if (paramList == null)
    {
      AppMethodBeat.o(214485);
      return;
    }
    this.mLeftWheelItems = paramList;
    this.mRightWheelItems = paramList1;
    this.mIsLinkage = true;
    this.mWheelViewLeft.setAdapter(new a(this.mLeftWheelItems));
    this.mWheelViewLeft.setCurrentItem(0);
    if (this.mLeftWheelItems != null) {
      this.mWheelViewRight.setAdapter(new a((List)this.mRightWheelItems.get(0)));
    }
    this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
    if (paramList != null) {
      this.mWheelViewLeft.setOnItemSelectedListener(new c()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(214476);
          if (KindaPickerViewImpl.this.mOnSelectChangeListener == null)
          {
            AppMethodBeat.o(214476);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          localArrayList.add(Integer.valueOf(0));
          if (KindaPickerViewImpl.this.mRightWheelItems != null)
          {
            KindaPickerViewImpl.this.mWheelViewRight.setAdapter(new a((List)KindaPickerViewImpl.this.mRightWheelItems.get(paramAnonymousInt)));
            KindaPickerViewImpl.this.mWheelViewRight.setCurrentItem(0);
          }
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          AppMethodBeat.o(214476);
        }
      });
    }
    if (paramList1 != null) {
      this.mWheelViewRight.setOnItemSelectedListener(new c()
      {
        public void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(214477);
          if (KindaPickerViewImpl.this.mOnSelectChangeListener == null)
          {
            AppMethodBeat.o(214477);
            return;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
          localArrayList.add(Integer.valueOf(paramAnonymousInt));
          KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(localArrayList);
          AppMethodBeat.o(214477);
        }
      });
    }
    AppMethodBeat.o(214485);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(214491);
    this.mWheelViewLeft.setCyclic(paramBoolean);
    this.mWheelViewRight.setCyclic(paramBoolean);
    AppMethodBeat.o(214491);
  }
  
  public void setOnSelectChangeListener(OnSelectChangeListener paramOnSelectChangeListener)
  {
    this.mOnSelectChangeListener = paramOnSelectChangeListener;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(214494);
    this.mWheelViewLeft.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWheelViewRight.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(214494);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(214489);
    this.mWheelViewLeft.aps(paramInt);
    this.mWheelViewRight.aps(paramInt);
    AppMethodBeat.o(214489);
  }
  
  static abstract interface OnSelectChangeListener
  {
    public abstract void onSelected(ArrayList<Integer> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPickerViewImpl
 * JD-Core Version:    0.7.0.1
 */
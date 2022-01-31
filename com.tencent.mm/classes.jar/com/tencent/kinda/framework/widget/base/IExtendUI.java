package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.mm.wallet_core.ui.a;

public abstract interface IExtendUI
{
  public abstract void hideTenpayKB();
  
  public abstract void scrollTo(View paramView, int paramInt1, int paramInt2);
  
  public abstract void scrollToFormEditPosAfterShowTenPay(View paramView1, View paramView2, int paramInt);
  
  public abstract void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean);
  
  public abstract void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setTenpayKBStateListener(a parama);
  
  public abstract void showTenpayKB();
  
  public abstract void showVKB();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.IExtendUI
 * JD-Core Version:    0.7.0.1
 */
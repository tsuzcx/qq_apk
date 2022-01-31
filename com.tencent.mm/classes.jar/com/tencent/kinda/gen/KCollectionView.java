package com.tencent.kinda.gen;

public abstract interface KCollectionView
  extends KView
{
  public abstract void cellRefreshImpl(VoidKViewLayoutCallback paramVoidKViewLayoutCallback);
  
  public abstract void didHighlightItemImpl(VoidCallback paramVoidCallback);
  
  public abstract void didSelectedItemImpl(VoidCallback paramVoidCallback);
  
  public abstract void didUnHighlightItemImpl(VoidCallback paramVoidCallback);
  
  public abstract void footerForSectionImpl(KViewLayoutCallback paramKViewLayoutCallback);
  
  public abstract void footerRefreshImpl(VoidKViewLayoutCallback paramVoidKViewLayoutCallback);
  
  public abstract String footerType();
  
  public abstract boolean getAlwaysBounceHorizontal();
  
  public abstract boolean getAlwaysBounceVertical();
  
  public abstract boolean getBounces();
  
  public abstract KPoint getContentOffset();
  
  public abstract boolean getPagingEnabled();
  
  public abstract boolean getScrollEnabled();
  
  public abstract boolean getScrollToTop();
  
  public abstract boolean getShowsHorizontalIndicator();
  
  public abstract boolean getShowsVerticalIndicator();
  
  public abstract void headerForSectionImpl(KViewLayoutCallback paramKViewLayoutCallback);
  
  public abstract void headerRefreshImpl(VoidKViewLayoutCallback paramVoidKViewLayoutCallback);
  
  public abstract String headerType();
  
  public abstract void itemForPositionImpl(KViewLayoutCallback paramKViewLayoutCallback);
  
  public abstract String itemType();
  
  public abstract void numberOfRowsAtSectionImpl(I64Callback paramI64Callback);
  
  public abstract void numberOfSectionsImpl(I64Callback paramI64Callback);
  
  public abstract void registerFooterType(String paramString);
  
  public abstract void registerHeaderType(String paramString);
  
  public abstract void registerItemType(String paramString);
  
  public abstract void reloadData();
  
  public abstract void reloadItemAtSection(long paramLong1, long paramLong2);
  
  public abstract void reloadSection(long paramLong);
  
  public abstract long row();
  
  public abstract long section();
  
  public abstract void setAlwaysBounceHorizontal(boolean paramBoolean);
  
  public abstract void setAlwaysBounceVertical(boolean paramBoolean);
  
  public abstract void setBounces(boolean paramBoolean);
  
  public abstract void setContentOffset(KPoint paramKPoint, boolean paramBoolean);
  
  public abstract void setPagingEnabled(boolean paramBoolean);
  
  public abstract void setScrollEnabled(boolean paramBoolean);
  
  public abstract void setScrollToTop(boolean paramBoolean);
  
  public abstract void setShowsHorizontalIndicator(boolean paramBoolean);
  
  public abstract void setShowsVerticalIndicator(boolean paramBoolean);
  
  public abstract void shouldHighlightItemImpl(BoolCallback paramBoolCallback);
  
  public abstract void sizeForFooterImpl(KSizeCallback paramKSizeCallback);
  
  public abstract void sizeForHeaderImpl(KSizeCallback paramKSizeCallback);
  
  public abstract void sizeForItemImpl(KSizeCallback paramKSizeCallback);
  
  public abstract void typeForFooterImpl(StringCallback paramStringCallback);
  
  public abstract void typeForHeaderImpl(StringCallback paramStringCallback);
  
  public abstract void typeForItemImpl(StringCallback paramStringCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KCollectionView
 * JD-Core Version:    0.7.0.1
 */
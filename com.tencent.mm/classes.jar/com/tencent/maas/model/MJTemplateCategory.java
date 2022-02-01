package com.tencent.maas.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class MJTemplateCategory
{
  private int CategoryType;
  private int FoldIndex;
  private String categoryID;
  private String displayName;
  private Object[] templateInfoObjs;
  private String thumbnailURL;
  
  public MJTemplateCategory(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    this.categoryID = paramString1;
    this.thumbnailURL = paramString2;
    this.displayName = paramString3;
    this.FoldIndex = paramInt1;
    this.CategoryType = paramInt2;
    this.templateInfoObjs = paramArrayOfObject;
  }
  
  public String getCategoryID()
  {
    return this.categoryID;
  }
  
  public int getCategoryType()
  {
    return this.CategoryType;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public int getFoldIndex()
  {
    return this.FoldIndex;
  }
  
  public Object[] getTemplateInfoObjs()
  {
    return this.templateInfoObjs;
  }
  
  public List<MJTemplateInfo> getTemplateInfos()
  {
    AppMethodBeat.i(216808);
    ArrayList localArrayList = new ArrayList();
    if (this.templateInfoObjs != null)
    {
      Object[] arrayOfObject = this.templateInfoObjs;
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add((MJTemplateInfo)arrayOfObject[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(216808);
    return localArrayList;
  }
  
  public String getThumbnailURL()
  {
    return this.thumbnailURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJTemplateCategory
 * JD-Core Version:    0.7.0.1
 */
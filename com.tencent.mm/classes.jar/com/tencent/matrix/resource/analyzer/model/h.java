package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h
  implements Serializable
{
  public final List<j> elements;
  
  public h(List<j> paramList)
  {
    this.elements = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.elements.size())
    {
      j localj = (j)this.elements.get(i);
      localStringBuilder.append("* ");
      if (i == 0) {
        localStringBuilder.append("GC ROOT ");
      }
      for (;;)
      {
        localStringBuilder.append(localj).append('\n');
        i += 1;
        break;
        if (i == this.elements.size() - 1) {
          localStringBuilder.append("leaks ");
        } else {
          localStringBuilder.append("references ");
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.h
 * JD-Core Version:    0.7.0.1
 */
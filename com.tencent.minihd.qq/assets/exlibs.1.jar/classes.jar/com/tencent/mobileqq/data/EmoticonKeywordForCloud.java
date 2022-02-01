package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId,keyword")
public class EmoticonKeywordForCloud
  extends EmoticonKeyword
{
  public static final int EM_TYPE_LOADING = 1;
  public static final int EM_TYPE_LOAD_FAILED = 3;
  public static final int EM_TYPE_LOAD_OK = 2;
  public static final int EM_TYPE_UNKNOW = 0;
  public int loadedType;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonKeywordForCloud
 * JD-Core Version:    0.7.0.1
 */
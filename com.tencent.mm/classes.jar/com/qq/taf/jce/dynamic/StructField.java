package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;

public class StructField
  extends JceField
{
  private static final Comparator<JceField> tagComp;
  private JceField[] data;
  
  static
  {
    AppMethodBeat.i(109565);
    tagComp = new Comparator()
    {
      public int compare(JceField paramAnonymousJceField1, JceField paramAnonymousJceField2)
      {
        AppMethodBeat.i(109563);
        int i = paramAnonymousJceField1.getTag();
        int j = paramAnonymousJceField2.getTag();
        AppMethodBeat.o(109563);
        return i - j;
      }
    };
    AppMethodBeat.o(109565);
  }
  
  StructField(JceField[] paramArrayOfJceField, int paramInt)
  {
    super(paramInt);
    this.data = paramArrayOfJceField;
  }
  
  public JceField[] get()
  {
    return this.data;
  }
  
  public JceField getFieldByTag(int paramInt)
  {
    AppMethodBeat.i(109567);
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      JceField localJceField = this.data[paramInt];
      AppMethodBeat.o(109567);
      return localJceField;
    }
    AppMethodBeat.o(109567);
    return null;
  }
  
  public boolean setByTag(int paramInt, JceField paramJceField)
  {
    AppMethodBeat.i(109566);
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      this.data[paramInt] = paramJceField;
      AppMethodBeat.o(109566);
      return true;
    }
    int i = -paramInt - 1;
    JceField[] arrayOfJceField = new JceField[this.data.length + 1];
    paramInt = 0;
    if (paramInt >= i)
    {
      arrayOfJceField[i] = paramJceField;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt >= this.data.length)
      {
        AppMethodBeat.o(109566);
        return false;
        arrayOfJceField[paramInt] = this.data[paramInt];
        paramInt += 1;
        break;
      }
      arrayOfJceField[(paramInt + 1)] = this.data[paramInt];
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.StructField
 * JD-Core Version:    0.7.0.1
 */
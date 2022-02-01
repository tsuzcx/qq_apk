import com.tencent.mobileqq.magicface.view.GLRender;

public class jek
{
  public float a;
  public int a;
  public boolean a;
  public byte[] a;
  public int b;
  public byte[] b;
  public int c;
  public int d;
  
  public jek(GLRender paramGLRender)
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label21;
      }
    }
    label21:
    do
    {
      return false;
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte1.length);
      this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
    } while (this.jdField_b_of_type_ArrayOfByte == null);
    System.arraycopy(paramArrayOfByte2, 0, this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte2.length);
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jek
 * JD-Core Version:    0.7.0.1
 */
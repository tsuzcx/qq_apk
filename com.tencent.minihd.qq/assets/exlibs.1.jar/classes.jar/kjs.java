import java.nio.ByteBuffer;

public class kjs
{
  public static final int a = 9;
  public final long a;
  public final int b;
  public final long b;
  
  public kjs(ByteBuffer paramByteBuffer)
  {
    this.jdField_b_of_type_Int = (paramByteBuffer.get() & 0xFFFF);
    this.a = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.jdField_b_of_type_Long = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjs
 * JD-Core Version:    0.7.0.1
 */
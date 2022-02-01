package androidx.camera.core;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

final class ImageProcessingUtil
{
  private static int Ik;
  
  static
  {
    AppMethodBeat.i(198609);
    Ik = 0;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("image_processing_util_jni");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "androidx/camera/core/ImageProcessingUtil", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "androidx/camera/core/ImageProcessingUtil", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(198609);
  }
  
  private static native int nativeConvertAndroid420ToABGR(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5, Surface paramSurface, ByteBuffer paramByteBuffer4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  private static native int nativeRotateYUV(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer4, int paramInt5, int paramInt6, ByteBuffer paramByteBuffer5, int paramInt7, int paramInt8, ByteBuffer paramByteBuffer6, int paramInt9, int paramInt10, ByteBuffer paramByteBuffer7, ByteBuffer paramByteBuffer8, ByteBuffer paramByteBuffer9, int paramInt11, int paramInt12, int paramInt13);
  
  private static native int nativeShiftPixel(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.camera.core.ImageProcessingUtil
 * JD-Core Version:    0.7.0.1
 */
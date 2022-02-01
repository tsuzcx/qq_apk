import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;

public final class cvh
{
  private static SecureRandom jdField_a_of_type_JavaSecuritySecureRandom = new SecureRandom();
  private long jdField_a_of_type_Long = 5000L;
  
  private static void a(SelectionKey paramSelectionKey, long paramLong)
  {
    paramLong -= System.currentTimeMillis();
    int i = 0;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    }
    while (i == 0)
    {
      throw new SocketTimeoutException();
      if (paramLong == 0L) {
        i = paramSelectionKey.selector().selectNow();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    localDatagramChannel = null;
    try
    {
      localObject = DatagramChannel.open();
      ((SelectableChannel)localObject).configureBlocking(false);
      localObject = ((SelectableChannel)localObject).register(Selector.open(), 1);
      try
      {
        localDatagramChannel = (DatagramChannel)((SelectionKey)localObject).channel();
        InetSocketAddress localInetSocketAddress = new InetSocketAddress(jdField_a_of_type_JavaSecuritySecureRandom.nextInt(64511) + 1024);
        localDatagramChannel.socket().bind(localInetSocketAddress);
        localDatagramChannel.connect(new InetSocketAddress(InetAddress.getByName(paramString), 53));
        localDatagramChannel.write(ByteBuffer.wrap(paramArrayOfByte));
        paramString = new byte[512];
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
      }
      finally
      {
        try
        {
          long l2;
          while (!((SelectionKey)localObject).isReadable()) {
            a((SelectionKey)localObject, l1 + l2);
          }
          if (paramArrayOfByte == null) {
            break label174;
          }
        }
        finally
        {
          if (((SelectionKey)localObject).isValid()) {
            ((SelectionKey)localObject).interestOps(0);
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        long l1;
        int i;
        paramArrayOfByte = localDatagramChannel;
      }
    }
    paramArrayOfByte.selector().close();
    paramArrayOfByte.channel().close();
    label174:
    throw paramString;
    if (((SelectionKey)localObject).isValid()) {
      ((SelectionKey)localObject).interestOps(0);
    }
    l1 = localDatagramChannel.read(ByteBuffer.wrap(paramString));
    if (l1 > 0L)
    {
      i = (int)l1;
      paramArrayOfByte = new byte[i];
      System.arraycopy(paramString, 0, paramArrayOfByte, 0, i);
      if (localObject != null)
      {
        ((SelectionKey)localObject).selector().close();
        ((SelectionKey)localObject).channel().close();
      }
      return paramArrayOfByte;
    }
    if (localObject != null)
    {
      ((SelectionKey)localObject).selector().close();
      ((SelectionKey)localObject).channel().close();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvh
 * JD-Core Version:    0.7.0.1
 */